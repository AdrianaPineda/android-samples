# Android 101

## Activity

Current screen for an application that's running. Entry point into your application for the system.
It has a lifecycle, a UI. But when the user dismisses it, its gone

## Intent

Its a way to lik to other apps, to activities.

It's a bag or a bundle of information that you use to send to other components on the Android
device. And this can be between your app and any app on the device.

Implicit Intent / Action: you dont specify exactly who's supposed to do it but you know what should
get done. And the Android system will try to find and app either in your app or externally that can
do that action (sending a link, taking a photo)

## Background work

1. Thread
2. Executors
3. AsyncTasks
4. Services

### Threads

* Executes a runnable on a background thread
* Pros:
    * Run independently on the UI thread
    * Ideal for running concurrent processing
* Cons:
    * Must be explicitly managed (no life cycle)
    * Overhead when creating / destroying threads

### Executors

* To control threads creation / destruction
* Reduce the overhead of per task invocation
* Implemented with Executor e.g ThreadPoolExecution
    * For example, when downloading images
* Configurable
    * Default pool size, max pool size
    * KeepAlive time: useful to avoid destroying threads immediately when its not necessary
    * Blocking queue: useful to get work done on a particular order

### AsyncTasks

* To use method to perfom background operations and publish results on UI thread
* Pros:
    * Convenient and easy
* Cons:
    * Can easily leak (e.g onConfigurationChanged())
        * When the async task is running and the activity is destroyed, the activity is supposed to
          handle whatever comes back from it but the activity has been destroyed. Although the
          AsyncTask is still holding a reference to the activity, planning to tell it when it's
          finished -> leak. Also, we would want to start a new AsyncTask, cancel the old one and
          find a way to pipe the AsyncTask to the new activity that gets created -> not that simple
    * No concurrent operations (static executor)

### Services

Its an Android component like an Activity

* Service
    * Lifecycle callbacks all run on main thread
    * Independent of activities
    * Can run threads, use executors, etc
* IntentService: specific class of service that works on taking the intent you give it to start it
  and uses that to queue some background work. It creates a single thread which it uses as a queue,
  and it piles up work until it runs out of work and then that thread will quit
    * Uses a background thread to execute requests
    * Destroys the thread and service once executed
    * Multiple requests are queued and executed serially

NOTE: all android components are called from the UI thread when they are giving you callbacks from
the Android system

#### What can launch a service?

* Intent:
    * Message object used by an Activity to launch a service
    * eg. upload a file upon user request
* Alarm:
    * Signal at a specific time or interval
    * eg. poll server for updates
* GCM:
    * Push received via Google Cloud messaging
    * eg. chat message received
* Receiver:
    * Message is broadcast globally or internal to the app
    * eg. perform task on device boot

#### Common service tasks

* Notification: dashboard notification
* Broadcast: send broadcast message
* Database: write data to local database
* Files: cache images or JSON

#### Creating and launching an IntentService

Steps:

1. Create IntentService subclass: work will be called on a background thread
2. Register the Service
3. Launch the Service `startService`
4. Report results

By default, services run in the same process as the application. (process # background thread)

#### Activity & service communication

* Services communicate using broadcasts
* Activities or fragments can listen for broadcasts with Receivers

** Broadcast Communication **

1. In Service class -> Broadcast Intent w/ACTION (unique string)
2. In Activity -> create a BroadcastReceiver & register Receiver to listen to ACTION

NOTES:

- Make sure you don't unregister the same receiver in two different callbacks that can be called
  independently
- The system will throw an exception if we try to unregister a non-registered receiver