from urllib import request

r = request.urlopen("http://google.com")
print(r.getcode())
print(r.read())
