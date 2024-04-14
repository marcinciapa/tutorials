#  pip3 install pyttsx3

import requests
import json
import pyttsx3

url = "http://official-joke-api.appspot.com/jokes/ten"
response = requests.get(url)
json = json.loads(response.text)

engine = pyttsx3.init()

for joke in json:
   engine.say(f"{joke["setup"]} {joke["punchline"]}")
