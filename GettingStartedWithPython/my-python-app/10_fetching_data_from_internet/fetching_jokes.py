#  Official joke API: https://github.com/15Dkatz/official_joke_api

from urllib import request
import json

url = "http://official-joke-api.appspot.com/jokes/ten"
r = request.urlopen(url)
print(r.getcode())
data = r.read()
print(data)

json_data = json.loads(data)
print(json_data)


class Joke:
    def __init__(self, setup, punchline):
        self.setup = setup
        self.punchline = punchline

    def __str__(self):
        return f"{self.setup} {self.punchline}"


for joke in json_data:
    print(f"{joke["setup"]} {joke["punchline"]}")

jokes = []

for joke in json_data:
    j = Joke(joke["setup"], joke["punchline"])
    jokes.append(j)

print(len(jokes))
for joke in jokes:
    print(joke)
