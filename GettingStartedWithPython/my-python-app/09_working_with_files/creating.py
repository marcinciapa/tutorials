file = open("./data.csv", "w")
file = open("./data.csv", "r+")  # read + write
file.write("id,name,email\n")  # new line is necessary to separate lines
file.write("1,Jamila,jamila@gmail.com\n")
file.write("2,Alex,alex@gmail.com\n")
file.close()  # file should be closed after operations were performed on the file

file = open("./data.csv", "a")  # append
file.write("3,Samir,samir@gmail.com\n")
file.close()

