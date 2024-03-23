name = "Jamila"
lastName = "J"
age = 20
PI: float = 3.14
number = [1, 2, 3, 4]
fullName = name + " " + lastName  # concatenating strings
isAdult = True


comment = "Jamila is a very kind person" \
    "She is very responsible." \
    "This comment will be reduced to one line"
multilineComment = """
This is a multiline comment.
This will not be reduced to a single line.
"""

print("name", name, type(name))
print("age", age, type(age))
print("pi", PI, type(PI))
print("number", number, type(number))
print("Full name", fullName, type(fullName))
print("is adult", isAdult, type(isAdult))
print("comment", comment)
print("multiline comment", multilineComment)

email = """
hello {},
how are you?
It was nice to talk to you
"""
print(email.format(name))

# Alternatively:
anotherEmail = f"""
Hello {name},
Here is another message to you
"""
print(anotherEmail)

print(type(name) == type(fullName))
print(type(name) == type(PI))
print(name == name)

# Python is dynamically typed, variable is redefined when another type is assigned:
brand: str = "Amigoscode"
brand = False


# Functions must be defined before they are used:
def hello(message):
    print("Message:", message, type(message))


hello(brand)

"""
This is a multiline comment
Each line doesn't have to start with #
"""

# Strings can be defined using "" or ''
brand = 'Amigoscode'
print(brand)
print(brand.upper())
print(brand.replace('A', 'aa'))
print(len(brand))

print(brand == "amigoscode")  # false, it's Amigoscode
print(brand != "Amigoscode")  # false, it actually is
print("code" in brand)  # should be true
print("code" not in brand)  # false


# Not allowed, python is indentation-sensitive
# firstName = "Maria"
#     lastName = "Jamila"

# Sub-procedures must be indented
def my_function():
    firstName = "Maria"
    lastName = "Jamila"


import keyword
print(keyword.kwlist)