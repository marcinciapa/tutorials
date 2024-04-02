person = {
    "name": "Jamal",
    "age": 20,
    "address": "USA"
}

print(person["name"])  # Jamal
# print(person["nam"])  # key error: key not found
print(person["age"])  # 20
print(person["address"])  # USA

print(person.keys())  # name, age, address
print(person.values())  # Jamal, 20, USA
print(person.get("age"))  # 20

person["age"] = 100
print(person["age"])  # 100

person.clear()
print(person)  # {}
