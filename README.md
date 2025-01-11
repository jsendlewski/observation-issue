# Description

Seems like there's an issue with clearing ThreadLocals when using net.ttddyy.observation:datasource-micrometer-spring-boot lib with otel bridge.

Running this application and creating some traffic on "/" path, nicely exposes the issue as seen in Jaeger:

<img width="375" alt="image" src="https://github.com/user-attachments/assets/7fde25a7-04d9-4d4f-b24f-996788ed7c4a" />



# Steps to reproduce
1. Run this sample app
2. Run some workload against "/" endpoint (POST method)
3. Check logs -  you will see duplicates in traceIds where there should be none
4. Optionally - set up Jaeger to visualise issue there.

Note: Removing net.ttddyy.observation:datasource-micrometer-spring-boot will fix the issue.
