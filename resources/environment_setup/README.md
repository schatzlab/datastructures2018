# Environment Setup

* [Machine](#machine)
  * [Windows](#windows)
  * [MacOS](#macos)
  * [Linux](#linux)
  * [Virtual Machine](#virtual-machine-instructions)
* [Tools](#tools)
  * [JUnit](#downloading-junit)
  * [Checkstyle](#downloading-checkstyle)
* [Optional Development Tools](#optional-development-tools)

You have various options for your machine and environment, but we will expect your programs to compile and run on a Linux machine, so we provide you with an Ubuntu Virtual Machine (VM). You have this option regardless of what your primary computer is, but you have some other options depending on your machine. _Regardless of how you develop we will expect your code to work on our Linux VM._

Whatever terminal you have for developing, you should check your Java version by running the command
`$ java -version`. With the right version installed, you should see something like this:
```
openjdk version "1.8.0_181"
OpenJDK Runtime Environment (build 1.8.0_181-...-b13)
OpenJDK 64-Bit Server VM (build 25.181-b13, mixed mode)
```
Note this is the latest build of Java 8 (as of August, 2018) so you may want to update if you have an older build. Be careful not to accidentally switch to Java 10 since we will be using Java 8.

_You will get confirmation that your code compiled and executed when our auto-grader runs on gradescope._

## Machine
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
To setup your virtual machine, you will first need some software that can run your virtual machine. Our go-to is [VirtualBox](https://www.virtualbox.org/) which can be downloaded [here](https://www.virtualbox.org/wiki/Downloads). In VM terminology, the *host* is the machine that you have (that will host our Linux Virtual Machine). So download the host for the OS you have.

Next, you will want to download the VM we have set up. To do so, simply download the tarball [here](TODO-need to put somewhere can be retrieved because is such a big file, piazza maybe?), and double-click the cs226.ova file. This should automatically add the machine in VirtualBox with all of the installed tools, but there are still a few things you will want to do.

The default username is `cs226` and the default password is `password`. You can change these if you'd like, as well as the name of the computer.

First, you'll want to install the virtual box guest additions for this machine. You can follow instructions [here](https://virtualboxes.org/doc/installing-guest-additions-on-ubuntu/) to get the guest additions. This allows for improved graphics, clipboard sharing, etc.

Next, you will want to configure some settings. Launch VirtualBox and single-click (i.e. do not start) the machine you just installed (cs226). Click "Settings", and change the name if you'd like. Select the "Advanced" tab under the "General" screen and change both of "Shared Clipboard" and "Drag'n'Drop" to "Bidirectional". This allows you to copy and paste from host to the VM and vise versa. If you go to the System screen you could change the amount of memory used, it defaults to 2048MB. Click "OK" when done to apply these settings. Now when you boot up the VM you should have this sharing functionality.

For sharing files between the VM and your computer you have a few options. I would reccommend just using Git, but you can also drag and drop, submit directly in the VM, or experiment with shared folders (I haven't dabbled with this so I don't want to give any input).

Some general notes for using the VM
* Check out `~/.bash_aliases` to see some of the shortcuts I've included and add your own.
* Customize your terminal by editing `~/.bashrc`
* Don't ever just exit out of the VM, make sure you power off and let the machine shut down on it's own.

## Tools
---

### Downloading JUnit

To download JUnit, you can run `$ sudo apt-get install junit4` (JUnit 4 is the version we use but it is not as important as far as writing your own tests). This will install the jar file right to where all of your other jar files should be. You can also retrieve the jar file directly from the JUnit Releases GitHub page [here](https://github.com/junit-team/junit4/releases). Regardless, you should kknow where the jar file is so you can point to this location when you go to run it. For examples of how to run it, see the [test](https://github.com/schatzlab/datastructures2018/tree/tk-resources/resources/environment_setup/test) folder.

Note that you won't necesarily need JUnit working the first week, but it is good to know in the back of your mind you will need to have it at some point.

### Downloading Checkstyle

Checkstyle can also be a downloaded jar file (among other ways but this is the most straightforward in my opinion). You can retrieve the Checkstyle jar file from the Checkstyle GitHub Releases page [here](https://github.com/checkstyle/checkstyle/releases/)

Checkstyle relies on java with a classpath to this jar file, along with the configuration file (which we have provided [here](https://github.com/schatzlab/datastructures2018/blob/tk-resources/resources/cs226_checks.xml)).

Note that the Checkstyle enforces documents do not contain any tab characters, it may be worthwhile to find some editor that allows for soft tabs (Atom and Sublime also give functionality to convert tabs to spaces, among editors).

---

## Optional Development Tools

### Editors
* [Atom](https://atom.io/)
  Great, customizable editor. Has ability to download and use various tools/packages to fit your use. There are ways to work in linters (such as checkstyle) and terminals in the same window. It also gives some GUI interaction for Git and version control. Totally free.
* [Sublime Text](https://www.sublimetext.com/download)
  Sort of a simplistic, light-weight, version of Atom. Looks great, but downloading plugins/packages not as straight-forward. Free but will bug you to buy a license
* [Notepad++](https://notepad-plus-plus.org/)
  Very simple, quick, text editor. Windows only.

There are other full-blown IDE's you could experiment with, but a simple text editor should do.

### Version Control
Note that it is very important you make your repositories private! [GitHub](https://github.com/) is awesome but to make a private repository you must pay. [BitBucket](https://bitbucket.org/) lets you have private repositories without paying. Understand the difference between "Git" the tool, and sites that host Git repositories (such as GitHub and BitBucket).

* [GitHub Desktop](https://desktop.github.com/)
  Helpful GUI version of Git. Requires a GitHub account though
* [Git for Windows](https://gitforwindows.org/)
