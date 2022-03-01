echo  "Starting helloyocto application " >> /home/root/hello.log


tmux new-session -d -s mahmoud "python3 /usr/bin/helloyocto.py"

