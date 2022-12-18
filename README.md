This is for the Dropwizard App (Server):
Execute the following commands in the root directory
1. docker build -t server SA55_YeoMinXiuSherlin_fibonacci/fibonacci-server/
2. docker run -dp 8000:8000 server
(Host Port 8000 mapped to Container Port 8000 when the application is configured to run on)

This is for the React App (Client):
Execute the following commands in the root directory
1. docker build -t client SA55_YeoMinXiuSherlin_fibonacci/fibonacci-client/
2. docker run -dp 80:3000 client
(Host Port 8000 mapped to Container Port 8000 when the application is configured to run on)

Instructions on how to deploy to Compute Instance:
Once compute instance (virtual machine) is created, need to use Command Line get virtual machine to
1. install git and docker with the respective links:
https://git-scm.com/download/linux
https://docs.docker.com/engine/install/centos/ 
2. clone my remote git repository (where the app source code is). 1 instance to client app. 1 instance to server app.
3. build docker image for the specific app
4. run docker image to get the instance (virtual machine) to create a docker container to run the map
5. Manage the ingress rules to allow for mapping of the app port settings (in the docker container) to the host port. e.g. allow TCP 80, means allow app access from other computers on container port 80 (where the app is running)
6. Need to ensure public IP address is created for public access
