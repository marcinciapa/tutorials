#  pip3 install requests

import requests
import json

url = "http://official-joke-api.appspot.com/jokes/ten"
response = requests.get(url)
print(response.status_code)
json = json.loads(response.text)

for joke in json:
   print(f"{joke["setup"]} {joke["punchline"]}")
