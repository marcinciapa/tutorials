file = open("./data.csv", "r")  # read
print(file.read())
file.close()

file = open("./data.csv", "r")  # read
for line in file:  # Convenient way of iterating through file lines:
    print(f"Next line: ${line}")

file.close()

file = open("./data.csv", "r")  # read
print(file.readlines())

