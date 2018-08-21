# Environment Setup

* [Windows](#windows)
* [MacOS](#macos)
* [Linux](#linux)
* [Virtual Machine](#virtual-machine-instructions)

You have various options for your machine and environment, but we will expect your programs to compile and run on a Linux machine, so we provide you with an Ubuntu Virtual Machine (VM). You have this option regardless of what your primary computer is, but you have some other options depending on your machine. _Regardless of how you develop we will expect your code to work on our Linux VM._

Whatever terminal you have for developing, you should check your Java version by running the command `$ java -version`. With the right version installed, you should see something like this:
```
openjdk version "1.8.0_181"
OpenJDK Runtime Environment (build 1.8.0_181-...-b13)
OpenJDK 64-Bit Server VM (build 25.181-b13, mixed mode)
```
Note this is the latest build of Java 8 (as of August, 2018) so you may want to update if you have an older build. Be careful not to accidentally switch to Java 10 since we will be using Java 8.

_You will get confirmation that your code compiled and executed when our auto-grader runs on gradescope_

---

### Windows
If you have a Windows machine, you can always use git for windows to get a unix shell and develop from there. It also gives you command line Git capabilities (which you could assume from the name. You can download git for windows [here](https://gitforwindows.org/).

If you have Windows 10, you can also install Ubuntu for Windows from the Microsoft Store. You can get a nice tutorial for setting it up [here](https://tutorials.ubuntu.com/tutorial/tutorial-ubuntu-on-windows#0)

### MacOS
If you have a Mac, you have a unix terminal. If you prefer developing here over the VM, that is fine but again, we will expect your code to work on the Linux machines. You should double check the version of Java you are working with, and you will be mostly on your own for setting up JUnit later.

### Linux
If you have a Linux machine you can likely rely on that for developing as is, but it can't hurt to use the VM. Again, make sure to use the correct versions, however.

---

### Virtual Machine Instructions
To setup your virtual machine, you will first need some software that can run your virtual machine. Our go-to is [VirtualBox](https://www.virtualbox.org/) which can be downloaded here [here](https://www.virtualbox.org/wiki/Downloads). In VM terminology, the *host* is the machine that you have (that will host our Linux Virtual Machine). So download the host for the OS you have.

Next, you will want to download the VM we have set up.

TODO - specific files and instructions, links, etc...
