import socket
print(socket.gethostname() )
HOST = '192.168.1.7'  # Standard loopback interface address (localhost)
PORT = 65432        # Port to listen on (non-privileged ports are > 1023)
try:
    while True:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            s.bind((HOST, PORT))
            s.listen()
            conn, addr = s.accept()
            with conn:
                print('connected to ', addr)
                while True:
                    data = conn.recv(1024)
                    print("recieved",str(data))
                    s.close()
                    if not data:
                        break

except:
    print("terminated")