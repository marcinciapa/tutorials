person = {
    "name": "Jamal",
    "age": 20,
    "address": "USA"
}

for key in person:
    print(f"{key}: {person[key]}")

for key, value in person.items():
    print(f"{key}: {value}")


print(person.items())  # dict_items([('key', 'value'])
