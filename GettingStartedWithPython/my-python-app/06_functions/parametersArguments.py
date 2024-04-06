def greet(name, age):
    print(f"Hello {name} how are you?")
    print(f"I know your age = {age}")


greet("Jamila", 12)
greet("Alex", 22)


def reGreet(name, age=-1):
    print(f"Hello {name}")
    if age >= 0:
        print(f"your age is {age}")


reGreet("Jamila")
reGreet("Alex", 22)
