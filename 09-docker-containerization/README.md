# Introduction to Docker and Containerization


<img src="https://bunnyacademy.b-cdn.net/what-is-docker.png" height="300" width="800" align="center">

- This repository serves as an introduction to Docker and explores the differences between virtualization and containerization. It aims to provide a basic 
  understanding of containerization technology and its advantages over traditional virtualization.

## Table of Contents

- [Docker Introduction](#docker-introduction)
- [Virtualization vs. Containerization](#virtualization-vs-containerization)
- [Docker Hub](#docker-hub)
- [Using Docker Hub](#using-docker-hub)
- [Docker Architecture](#docker-architecture-overview)
- [Managing Docker Images](#managing-docker-images)
- [Managing Docker Containers](#managing-docker-containers)
- [Running Docker Containers](#running-docker-containers)
- [Creating a Docker Image for Your Java Project](#Creating-a-Docker-Image-for-Your-Java-Project)
- [Sharing or Deploying Your Docker Image](#Sharing-or-Deploying-Your-Docker-Image)

## Docker Introduction

Docker is a containerization platform that allows you to package applications and their dependencies into a standardized unit called a "container." These containers can run consistently across various environments, making it easier to develop, ship, and deploy applications. Key concepts and advantages of Docker include:

- **Containers**: Lightweight, standalone, and executable packages that include everything needed to run an application, such as the code, runtime, system tools, and libraries.

- **Isolation**: Containers provide process-level isolation, allowing multiple containers to run on the same host without interfering with each other.

- **Portability**: Containers can run on any system that supports Docker, regardless of the underlying infrastructure.

- **Efficiency**: Docker containers share the host OS kernel, reducing resource overhead and improving performance.

## Virtualization vs. Containerization

### Virtualization

Virtualization is a technology that emulates a complete operating system (OS) and runs multiple virtual machines (VMs) on a single physical host. Each VM includes its own OS, applications, and libraries. Key characteristics of virtualization are:

- **Hypervisor**: Virtualization relies on a hypervisor to manage and allocate physical resources to VMs.

- **Resource Intensive**: VMs are resource-intensive as they include an entire OS.

- **Slower Boot Times**: VMs have slower boot times because they need to start the complete OS.

- **Large Disk Space**: VMs consume significant disk space due to their size.

- **Isolation**: VMs provide strong isolation between different virtual machines.

### Containerization

Containerization, as exemplified by Docker, is a lightweight form of virtualization that isolates and runs applications within containers. Containers share the host OS kernel and provide a more efficient and portable solution. Key characteristics of containerization are:

- **Docker Engine**: Docker uses the Docker Engine to run containers, which includes the Docker runtime and a shared kernel.

- **Resource Efficient**: Containers are resource-efficient because they share the host OS kernel.

- **Faster Boot Times**: Containers have faster boot times as they don't need to start a complete OS.

- **Smaller Disk Space**: Containers consume less disk space because they are smaller in size.

- **Isolation**: Containers provide process-level isolation but share the host OS kernel.

## Docker Hub

[Docker Hub](https://hub.docker.com/) is a cloud-based container registry that plays a crucial role in the Docker ecosystem. It serves as a platform for publishing, sharing, and discovering Docker container images. Here are some key aspects of Docker Hub:

- **Image Hosting**: Docker Hub hosts a vast collection of Docker container images for various applications, services, and tools. You can find official images, as well as user-contributed images, for a wide range of software.

- **Image Search**: Docker Hub offers a powerful search feature, making it easy to discover and find container images that suit your needs. You can search for images by name, tags, or keywords.

- **Image Versioning**: Container images on Docker Hub are versioned, allowing you to specify a particular image version to ensure consistency in your deployments.

- **Public and Private Repositories**: You can use Docker Hub to store both public and private repositories. Public repositories are accessible to everyone, while private repositories require authorization to access, providing security and control.

- **Automated Builds**: Docker Hub allows you to set up automated builds linked to your source code repositories. This means that whenever you push changes to your code repository, Docker Hub can automatically build and update the associated container image.

- **Docker Official Images**: Docker Hub hosts official images that are maintained and verified by the Docker community. These images are typically considered reliable and secure.

Using Docker Hub, you can easily pull and run container images, whether for development, testing, or production use. It's a valuable resource for the Docker community to collaborate, share, and leverage containerization technology.

For more information and to explore the vast collection of container images on Docker Hub, visit [Docker Hub](https://hub.docker.com/).

## Using Docker Hub

### Logging In to Docker Hub

Before you can pull or push Docker images to Docker Hub, you need to log in to your Docker Hub account. If you don't have an account, you can sign up for one on the [Docker Hub website](https://hub.docker.com/).

To log in to Docker Hub, open your terminal and run the following command:
```bash
docker login
```
You will be prompted to enter your Docker Hub username and password. Once logged in, your Docker credentials are stored securely.

If you need to log out of Docker Hub for any reason, use the following command:
```bash
docker logout
```
This command removes your Docker Hub credentials from your system.

To pull a Docker image from Docker Hub, use the docker pull command followed by the image name and tag (if applicable). Here's an example of pulling an Ubuntu image:
```bash
docker pull ubuntu:latest
 ```
This command downloads the latest Ubuntu image from Docker Hub.

After pulling an image, you can run a Docker container using the docker run command. For example, to start a new container based on the Ubuntu image you pulled:
```bash
docker run -it --name my-ubuntu-container ubuntu:latest
```
-it is used to run the container in interactive mode with a terminal.
--name allows you to specify a name for the container (replace my-ubuntu-container with your desired name).
ubuntu:latest is the name of the image you want to run.
This command will start a new Ubuntu container and drop you into an interactive shell within the container.
You can customize the docker run command based on your specific use case, including specifying environment variables, ports, and more.
Remember to replace ubuntu:latest with the name and tag of the image you want to run

## Docker Architecture Overview

Docker follows a client-server architecture, where the Docker client communicates with a Docker server (daemon). The server handles the management of containers, images, networks, and more. Here's a high-level view of Docker's architecture:

## Components of Docker

### Docker Daemon

The Docker daemon (or server) is the background service that manages Docker containers. It is responsible for building, running, and monitoring containers. Some key points about the Docker daemon include:

### Docker Client

The Docker client is a command-line tool used to interact with the Docker daemon. It allows users to issue commands to the Docker server and manage containers and images. You can also use graphical interfaces to interact with the Docker daemon.

### Docker Images

Docker images are read-only templates that serve as the basis for creating containers. Images include an application's code, runtime, libraries, and dependencies. Images can be shared and distributed through Docker Hub or other container registries.

### Docker Containers

Docker containers are lightweight, runnable instances of Docker images. They encapsulate an application and its environment, ensuring consistent and isolated execution. Containers are isolated from each other and from the host system, making them portable and secure.

## Container Runtimes

Docker supports different container runtimes, the most common being Docker's built-in container runtime (containerd). However, other runtimes like CRI-O and containerd can be used with Docker as well. These runtimes are responsible for running and managing containers and interact with the Linux kernel to provide the container's execution environment.

## Managing Docker Images

Docker allows you to manage container images efficiently, from listing and inspecting them to removing images you no longer need. In this section, we'll cover essential Docker image management commands.
### Listing Docker Images

To list Docker images currently stored on your local system, you can use the `docker images` command. This command provides details about the images, including repository, tag, image ID, creation date, and size. Here's the basic syntax:

```bash
docker images [OPTIONS]
```
Common options include:
-a or --all: Show all images, including intermediate image layers.
--digests: Display the image digests.
--no-trunc: Show full image IDs.

To remove Docker images that you no longer need, you can use the docker rmi command followed by the image ID or repository and tag. The basic syntax is:
```bash
docker rmi [OPTIONS] IMAGE [IMAGE...]
```
Common options include:
-f or --force: Force removal of the image, even if it's in use by running containers.

For example, to remove an image by its image ID:
```bash
docker rmi abcdef123456
```
Or to remove an image by its repository and tag:
```bash
docker rmi my-image:latest
```

## Managing Docker Containers

Docker containers are at the heart of containerization. They allow you to run applications and services in isolated environments. This section covers key Docker container management commands.

### List Running Containers

To list running containers, use the `docker ps` command. This command displays details about the containers, including their Container ID, status, names, and more. The basic syntax is:

```bash
docker ps [OPTIONS]
```
Common options include:
-a or --all: Show all containers, including those that are not currently running.

For example, to list all running containers:
```bash
docker ps
```

List All Containers
If you want to see all containers, including stopped ones, use the docker ps --all command (or docker ps -a). This will display a list of all containers, both running and stopped.
```bash
docker ps -a
```

Stop a Running Container
To stop a running container, you can use the docker stop command followed by the container ID or name. The basic syntax is:

```bash
docker stop container_id
```

Start a Stopped Container
If you have a stopped container that you want to start, you can use the docker start command followed by the container ID or name. Here's the basic syntax:

```bash
docker start container_id
```

Remove a Container
To remove a Docker container, you can use the docker rm command followed by the container ID or name. The basic syntax is:

```bash
docker rm container_id
```


## Running Docker Containers

The `docker run` command is fundamental for launching Docker containers. It allows you to create and run containers based on Docker images. In this section, we'll explore the `docker run` command and some common options.

### Basic `docker run` Command

The basic syntax of the `docker run` command is as follows:

```bash
docker run [OPTIONS] IMAGE [COMMAND] [ARG...]
```

OPTIONS are used to customize container behavior.
IMAGE specifies the Docker image to use.
COMMAND (optional) is the command to run inside the container.
ARG (optional) provides arguments to the command.

# Common Options

-d (Detached Mode)
Use the -d option to run a container in detached mode. This means the container runs in the background, and you get your terminal back for other tasks.
```bash
docker run -d IMAGE
```

-p (Port Mapping)
The -p option is used to map a container's port to a port on the host system. This is essential for exposing services running inside the container to the outside world.

Example:
```bash
docker run -p HOST_PORT:CONTAINER_PORT IMAGE
```

-it (Interactive Mode)
Combine the -i and -t options to run a container in interactive mode. This is often used for running containers that require user interaction, like a terminal session.

Example:
```bash
docker run -it IMAGE
```

-e (Environment Variables)
Use the -e option to set environment variables inside the container. This is useful for configuring application-specific settings.

Example:
```bash
docker run -e VAR_NAME=VAR_VALUE IMAGE
```

Putting It All Together
Here's an example of using multiple options with the docker run command:
```bash
docker run -d -p 8080:80 -e APP_ENV=production -it my-app-image
```
In this command, we:

Run a container in detached mode (-d).
Map host port 8080 to container port 80 (-p).
Set an environment variable APP_ENV to production (-e).
Run the container in interactive mode (-it).
Use the my-app-image Docker image.


## Creating a Docker Image for Your Java Project

Docker enables you to containerize your Java project, making it portable and consistent across different environments. To create a Docker image for your Java project, follow these steps:

### Step 1: Set Up a Dockerfile

1. In your project directory, create a Dockerfile. The Dockerfile is a text file that defines the configuration and content of the Docker image.

2. Choose a suitable base image for your Java application. You can use official OpenJDK images or other Java images based on your project's Java version. For example, to use OpenJDK 11, add the following line to your Dockerfile:
   
3. Use the COPY instruction in the Dockerfile to copy your Java project's build artifacts and any other necessary files into the image. For instance, to copy a JAR file into the image
    
```Dockerfile
# Use an official OpenJDK image as the base image
FROM openjdk:11

# Copy the Spring Boot application JAR into the image
COPY target/my-spring-boot-app.jar /app.jar

# Set an environment variable
ENV SPRING_PROFILES_ACTIVE=production

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "/app.jar"]
```

### Step 2: Build the Docker Image
Open a terminal and navigate to your project directory containing the Dockerfile.

Build the Docker image using the docker build command. Replace your-image-name with a name for your Docker image and your-tag with a version or tag for the image:

```bash
 docker build -t your-image-name:your-tag 
```

### Step 3: Verify the Image
After the build process completes, you can verify that the image was created by running the docker images command:

``` bash
docker images
```

### Step 4: Run the Container (Optional)
You can test your Docker image by running a container from it:

``` bash
docker run -d --name your-container-name your-image-name:your-tag
```

### Step 5: Share or Deploy
Once you have your Docker image, you can push it to a container registry (like Docker Hub) to share it with others or use it to deploy your Java project on different systems.


## Sharing or Deploying Your Docker Image

After creating a Docker image for your project, you can share it with others or deploy your application on different systems. Here are the steps to share or deploy your Docker image:

### Step 1: Push Your Image to a Container Registry (Sharing)

1.1. Log in to the container registry where you want to store your Docker image. Docker Hub (https://hub.docker.com/) is a popular choice, but there are other container registries available as well.

```bash
docker login
```

1.2. Tag your Docker image with the repository and version. Replace your-docker-hub-username with your Docker Hub username or organization name and your-image-name and your-tag with your image details.

``` bash
docker tag your-image-name:your-tag your-docker-hub-username/your-image-name:your-tag
```

1.3. Push your image to the container registry:

```bash
docker push your-docker-hub-username/your-image-name:your-tag
```

1.4. Your image is now available on the container registry, and others can pull it using `docker pull`.
