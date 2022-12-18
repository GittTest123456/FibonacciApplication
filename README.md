Instructions on how to build, run the container:
1. docker build -t "image_name" /.
2. docker run -p 8000:8000 "image_name"
(Host Port 8000 mapped to Container Port 8000 when the application is configured to run on)

Instructions on how to deploy to Compute Instance:
Once compute instance (virtual machine) is created, need to use Command Line get virtual machine to
a. install git
b. clone my remote git repository (where the app source code is). 1 instance to client app. 1 instance to server app.
c. install docker
d. build docker image for the specific app
e. run docker image to get the instance (virtual machine) to create a docker container to run the map
f. manage the ingress rules to allow for mapping of the app port settings (in the docker container) to the host port. e.g. allow TCP 80, means allow app access from other computers on container port 80 (where the app is running)
g. Need to ensure public IP address is created for public access
