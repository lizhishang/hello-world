#Here are the simple samples with Java Thread. 

Threads is ordered by scheduler.

If you want to create a thread you can:
* extend Thread
* implement Runnable
* implement Callable

and overwrite run() method.

Use start() method start a new thread.

Select extend class Thread or implement Runnable?
I think of implement Runnable is the better choose. 
The class just can extend the only one which you can choose, but you can implement many interface.

Thread Priority:
* NORM_PRIORITY 5 (DEFAULT)
* MIN_PRIORITY 1
* MAX_PRIORITY 10

Priority means possibility but no absolute do.

User Thread and Daemon Thread.
JVM will wait User Thread has done then shutdown. 

The Key word volatile make variable or data be visible in other thread.