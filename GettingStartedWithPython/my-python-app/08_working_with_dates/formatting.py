from datetime import datetime
from datetime import date

now = datetime.now()
print(now)  # current date time in default format
print(now.strftime("%d/%m/%Y %H:%M:%S"))  # current date time formatted
print(now.strftime("%d %b %Y %H:%M:%S"))  # current date time formatted
print(date.today().strftime("%d-%B-%Y"))  # current date formatted
