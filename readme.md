
# Context

We would like to see you in your element coding and how you approach problems when writing software. 

We will discuss your submission while screen sharing on a video call. 

You should write the solution in Java.

There should be a readme explaining what dependencies need to be installed, how to install them and how to run the project.

You don’t need to spend longer than 2 hours on the project. 

If there are things that still need to be done, then feel free to put them in the Readme.

# Submission
You should use git while developing the project and submit the .git directory alongside your code in a tar ball.

# Problem statement
We would like you to build an application that crawls the website https://www.java.com/en/

The program should follow the child links of the page, and the child links of the children and so on. 

The output should be a json site map to the console. 

The site map should include the following information:

- All the web pages accessible from the base url recursively
- For each web page the links that it has to other web pages


It’s up to you how you want to structure the site map data structure. 
Please note that we would like the program not only to follow links directly on https://www.java.com/en/ but also to get links of the links.

You should make it as fast as possible by parallelizing work whenever it’s appropriate.

In order to simplify the problem we will add the condition that the links that should be followed should be under the java.com domain or relative links (if you’re uncertain what a relative here is a decent resource https://www.coffeecup.com/help/articles/absolute-vsrelative-pathslinks/). In other words, if there is a link to google.com, do not follow it!

(otherwise the program will try to crawl the whole internet which may take a while J)

Good luck!