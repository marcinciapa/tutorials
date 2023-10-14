Codebase for [YouTube course](https://www.youtube.com/playlist?list=PLXy8DQl3058Na9intXhpWr1x7RQrz_b9H) for SpringBoot and Quartz Scheduler tutorial.

# Scope

Lesson 1: Starting and stopping Quartz scheduler
Lesson 2: Configuring Quartz Job and Trigger
Lesson 3: Scheduling a job
Lesson 4: Fetching running timers
Lesson 5: Updating and deleting timers
Lesson 6: Quartz jobs persistence

# Running
Running the application requires local MySQL instance running in Docker:
`docker-compose up -d`

Run the class `SpringBootQuartzTutorialApplication` in IntelliJ

# Testing

There is a file named `requests.txt` containing example HTTP requests to interact with application.

# What I learned

- Timer jobs may be split into **groups** (for example database jobs can be grouped together).
- Running jobs may be fetched from Quartz scheduler.
- A listener for trigger execution can be implemented.
- SQL script to create necessary Quartz tables can be downloaded from Quartz webpage.

