**Programming Assignment 1:** Percolation

**Write a program to estimate the value of the percolation threshold via Monte Carlo simulation.**

Install a Java programming environment. Install a Java programming environment on your computer by following these step-by-step instructions for your operating system [ Mac OS X · Windows · Linux ]. After following these instructions, the commands javac-algs4 and java-algs4 will classpath in algs4.jar, which contains Java classes for I/O and all of the algorithms in the textbook.

To access a class in algs4.jar, you need an import statement, such as the ones below:

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
Note that your code must be in the default package; if you use a package statement, the autograder will not be able to assess your work.

**Percolation**. Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Scientists have defined an abstract process known as percolation to model such situations.

**The model.** We model a percolation system using an n-by-n grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row. (For the insulating/metallic materials example, the open sites correspond to metallic materials, so that a system that percolates has a metallic path from top to bottom, with full sites conducting. For the porous substance example, the open sites correspond to empty space through which water might flow, so that a system that percolates lets water fill open sites, flowing from top to bottom.)


[![mutt dark](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled.png)](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled.png)
[![mutt dark](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled1.png)](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled1.png)
[![mutt dark](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled2.png)](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled2.png)
[![mutt dark](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled3.png)](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled3.png)
[![mutt dark](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled4.png)](https://github.com/kashaf12/Percolation-Java/blob/master/images/Untitled4.png)
