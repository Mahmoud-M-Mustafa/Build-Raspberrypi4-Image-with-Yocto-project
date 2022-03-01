from time import *
import socket
print(socket.gethostname())
sleep(5)

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
 s.connect(('192.168.1.7',65432))
 s.sendall(b'Hello from rpi4')
while True:
 print("Hello Yocto!")
 sleep(5)


