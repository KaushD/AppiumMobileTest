## Mobile Test Automation Framework:
  
<p>  <a href= "https://github.com/KaushD/AppiumMobileTest">This</a> is a sample test automation framework for Mobile apps using Appium, Java, TestNG with TDD approach.</p>

<a href="https://docs.google.com/presentation/d/1sf0MenR9RGUSajwhqMyh2F9u5isD9UgC/edit?usp=drive_link&ouid=116985892271874217580&rtpof=true&sd=true)"> [Click here for more details]</a></p>

<br>

## Appium 2 Architecture

![image](https://github.com/user-attachments/assets/25de115d-ed6f-4b9b-8cfb-fa2862706229)


### Key Components in Appium 2 Architecture:

1. Client (Test Scripts)

<li> Written in any supported language (Java, Python, C#, JavaScript, etc.).</li>
<li>Uses the WebDriver Protocol (W3C) to communicate with the server.</li>
<br>
  
2. Appium 2 Server
<li>Core component that handles session management.</li>
<li>Communicates with drivers via plugins and extensions.</li>
<br>
  
3. Drivers (Separate Installable Packages)

<li>Each platform (Android, iOS, Windows) has its own driver.</li>
<li>Examples: UIAutomator2 Driver, XCUITest Driver, Espresso Driver.</li>
<br>
  
4. Plugins (Extending Appium 2)
<li>Used for additional functionalities like reporting, image comparison, and test orchestration.</li>
<br>
  
5. Platform-Specific Automation

<li>The drivers interact with the OS-specific automation framework.</li>
<li>For Android: UIAutomator2, Espresso.</li>
<li>For iOS: XCUITest.</li>
<li>For Windows: WinAppDriver.</li>
<br>
  
6. Device Under Test

<li>Physical devices, emulators, or simulators where the app is tested.</li>
