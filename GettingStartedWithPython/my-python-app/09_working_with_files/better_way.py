with open("./data.csv", "r") as file:  # works as try with resouce in Java
    print(file.readlines())

import os.path  # to check if file exists

file_name = "not_existing.csv"
if os.path.isfile(file_name):
    with open(file_name, "r") as file:
        print(file.readlines())
else:
    print(f"File {file_name} does not exist")

file_name = "data.csv"
if os.path.isfile(file_name):
    with open(file_name, "r") as file:
        print(file.readlines())
else:
    print(f"File {file_name} does not exist")
