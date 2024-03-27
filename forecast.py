import sys
import pandas as pd
import numpy
import warnings
from statsmodels.tsa.arima.model import ARIMA
import pyodbc
from jproperties import Properties

warnings.filterwarnings("ignore")

#Loading properties
configs = Properties()
_configFilePath = 'db_config.properties'
with open(_configFilePath, 'rb') as read_prop:
    configs.load(read_prop)

# Creating connection
def _create_db_connection():
    # # Creating Connection String
    _cnxn_str = ("Driver={{SQL Server}};"
            "Server={0};"
            "Database={1};"
            "UID={2};"
            "PWD={3};").format(configs.get("server").data, configs.get("database").data, configs.get("user").data, configs.get("password").data)
    #returning connection object
    return pyodbc.connect(_cnxn_str)

# This function takes in query key, and other additional arguments as required by the sql query
# Returns framed formatted sql query as Result
def _frameSQLQuery(_queryKey, _inventory_id: int, _from_date, _to_date):
    sql_query = (configs.get(_queryKey).data).format(_inventory_id, _from_date, _to_date)
    print(sql_query)
    return sql_query

# This function takes in connection object and sql query to be run as Input and this is where we need to modify the output Dataframe if needed
# Returns Result as dataframe with the data returned by running the provided sql query
def _runSQLQueryUpdateDF(_cnxn,sql_query):
    df = pd.read_sql(sql_query, _cnxn)
    
    #dataframe content modification
    df.columns = df.loc[0]
    df = df.drop(0)
    return df

# This function takes in modified SQL Output Dataframe and no. of months to be forecasted as Input
# Returns Result as an Array of forecasted Quantity equal to no. of forecast months given as Input
def arima_forecast(dataDF,_forecast_months):
    model = ARIMA(dataDF.values, order=(4, 0, 0))
    model_fit = model.fit()
    forecast = model_fit.forecast(steps=_forecast_months)
    # print(forecast.values)
    return forecast

#_cnxn = _create_db_connection()
#query = _frameSQLQuery(query_key, inventory_id, from_date, to_date)
#queryOutputDF = _runSQLQueryUpdateDF(_cnxn,query)

#arima_forecast(queryOutputDF, forecast_months)
#print(arima_forecast(queryOutputDF, forecast_months))

def forecast_data(argv):

    #print(argv[1])

    args = argv[1].split(" ")

    #print(args)
    inventory_id = args[2].split("=")[1]
    from_date = args[3].split("=")[1]
    to_date = args[4].split("=")[1]
    forecast_months = int(args[1])
    query_key='forecast_quantity_within_date_range'
    _cnxn = _create_db_connection()

    query = _frameSQLQuery(query_key, inventory_id, from_date, to_date)

    queryOutputDF = _runSQLQueryUpdateDF(_cnxn, query)
    forecastResult = arima_forecast(queryOutputDF, forecast_months)

    numpy.savetxt('forecastOutput.txt', forecastResult, delimiter=",", fmt='%f')

    forecastResString = ",".join(map(str, list(forecastResult)))

    print(forecastResString)  


if __name__ == "__main__":

    forecast_data(sys.argv)
