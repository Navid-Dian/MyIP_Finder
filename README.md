<h2><strong>[Full] Tutorial: How to use your home computer from anywhere; set up and connect to your PC without additional remote desktop applications.</strong></h2>
<h3><strong>Introduction</strong></h3>
<p>Remote Desktop is a very convenient way to access other computer resources, unlike cloud storage, which is limited to accessing files. I found it useful mostly in five cases: 1) When you don't have access to the software you need on your portable devices such as a laptop, possibly due to the limited number of licenses you can have), 2) you don't have admin privilege to install third-party software (i.e., restricted computers), 3) you have a powerful computer somewhere (e.g., at home) but it's not portable or with you always (e.g., due to portability, security, etc.) 4) you need to use specific software, but you only have access to a portable computing device available, e.g., Tablets (e.g., iPads) or other Arm-based devices that are not capable of running an all x64/x86 software natively (e.g., M1 or M2 Macbooks) 5) you need to monitor a process conveniently and remotely, but the software or system does have built-in cloud services.</p>
<h3><strong>Scope</strong></h3>
<p>This tutorial applies to all computers that can run native remote desktop applications (e.g., Remote Desktop Connection, RDC), covers how to set up a Remote Desktop in Windows 10 &amp; 11, a free cloud storage space, use Windows Task Scheduler, and set up home automation phone apps and link them to Amazon Alexa. It also provides Java code for finding the public IP address of the host computer remotely.</p>
<h3>&nbsp;<strong>In the end, you will be able to:</strong></h3>
<ol>
<li>Find the Public IP address of the destination computer remotely</li>
<li>Setup router with dynamic Public IP address</li>
<li>Setup remote Desktop without additional software such as TeamViewer, AnyDesk, etc.</li>
<li>Power on your computer remotely.</li>
<li>Power on your computer with Virtual Voice Assistants such as <strong>Alexa</strong>, <strong>Siri</strong></li>
</ol>
<h3><strong>Main Challenges</strong></h3>
<p>Two main challenges prevent you from benefiting from using Remote Desktop without paying subscription fees or app purchases are:</p>
<ol>
<li>Knowing your Public IP address (i.e., Router's IP address)</li>
<li>Routing your connection through home network (Port Forwarding)</li>
</ol>
<p>, Which I will address both in this tutorial.</p>
<h3><strong>Approach</strong></h3>
<p>The approach of this tutorial is based on <strong>problem solving</strong> techniques, implemented in four steps, understanding the challenge, brainstorming, picking the best strategy, and deploying the solution. In each step, I will introduce the most feasible options available. More information on problem solving techniques: <a href="https://asq.org/quality-resources/problem-solving">https://asq.org/quality-resources/problem-solving</a></p>
<p><strong>/*</strong>One may argue that these challenges can be easily rectified by buying things (licenses, services, hardware) or, in other words, with money. This is true, but this tutorial intends to help individuals (e.g., students, etc.) who want to benefit from using the Remote Desktop Service with minimum or no cost.<strong>*/</strong></p>
<h3><strong>Limitation</strong></h3>
<p>The host computer must be powered continuously to use Remote Desktop conveniently and on demand. There is a way to turn on your computer on demand, called Wake-on-Lan (WoL) but it has some limitations (such as the host computer needs to be plugged in at all times, router and motherboard need to be configured and in some cases, you need to turn off fast booting, using a paid app/server to send the Magic Packet required for WoL, etc.), so I don't recommend it. Moreover, powering up your computer at all times increase energy consumption which is not desirable. Therefore, I will present a better solution in the following and trade-offs need to be considered along with an example of energy consumption calculation.</p>
<h3><strong>Requirement</strong></h3>
<p>All information explained from scratch and network setting knowledge is not required but would be beneficial. Depending on what level of automation is desirable, you may need to:</p>
<ul>
<li>Have required Hardware or platform for automation (3)</li>
<li>Have Alexa or Siri devices (4)</li>
<li>Have basic knowledge of Java programming language in case you would like to see what you run on your computer and what is in the Java app (5) otherwise, you can simply download the Java app from <a href="https://github.com/Navid-Dian/MyIP_Finder">here</a>.</li>
</ul>
<h3><strong>Configuration</strong></h3>
<h4>1. Allow access to your PC (PC settings) and allow access to your PC from outside your PC's network (Router settings) (2 steps).</h4>
<p>You create a peer-to-peer connection when you connect to your PC using a Remote Desktop client. This means you need direct access to the PC (sometimes called "the host"). So, first, you need to allow access to your PC by enabling RDC and defining a user account which allows having that access remotely. Second, If you need to connect to your PC from outside of the network (e.g., Internet), our aim, you need to enable that access too. You have a couple of options to do the latter: 1) use port forwarding or 2) set up a VPN.</p>
<p>Follow the instructions below to allow access to your PC (PC settings) [step 1]:</p>
<p><a href="https://learn.microsoft.com/en-us/windows-server/remote/remote-desktop-services/clients/remote-desktop-allow-access">https://learn.microsoft.com/en-us/windows-server/remote/remote-desktop-services/clients/remote-desktop-allow-access</a></p>
<p>Follow the instructions below to allow access to your PC from outside your PC's network (Router settings - port forwarding) [step 2]: Port forwarding simply maps the port on your router's IP address (your public IP) to the port and IP address of the PC you want to access. Specific steps for enabling port forwarding depend on the router you're using, so you'll need to search online for the specific router's instructions. For a general discussion of the steps, check out wikiHow or Microsoft, the links below to Set Up Port Forwarding on a Router.</p>
<p><a href="https://www.wikihow.com/Set-Up-Port-Forwarding-on-a-Router">https://www.wikihow.com/Set-Up-Port-Forwarding-on-a-Router</a></p>
<p><a href="https://learn.microsoft.com/en-us/windows-server/remote/remote-desktop-services/clients/remote-desktop-allow-outside-access?source=recommendations%3E">https://learn.microsoft.com/en-us/windows-server/remote/remote-desktop-services/clients/remote-desktop-allow-outside-access?source=recommendations%3E</a></p>
<p>Now that all set, you can use the remote desktop client application to connect your PC from anywhere but you need to have your computer's public IP address to find it on the Internet.</p>
<h4>2. Finding your Public IP address (your router's IP address):</h4>
<p>There are two different Internet Protocol (IP) addresses, public and private. Public IP addresses are used to be visible on the internet while private IP addresses are only used in private networks (e.g., home WiFi network) which are not visible on the internet. There are also two types of public IP addresses static and dynamic. Typically, static IP addresses are best for businesses which host their own websites and internet services. On the other hand, dynamic IP addresses are usually fine for most consumers. When your router receives a dynamic DHCP assigned IP address from your ISP there is a pre-defined time limit built into the assignment, this time limit is called a DHCP Lease. The typical lease time for ISPs in the United States is roughly 7 days. Therefore, you need to know your public IP address every time you want to connect to your host computer (e.g., home PC).</p>
<p>There are different ways to find your router&rsquo;s public IP address. For example, you can simply google it or see it in your router network status. Here are the ways to find your router's public IP address:</p>
<p>The fastest and easiest way to learn your public IP address is by asking a website to tell you. You can simply Google 'my IP address' or 'What's my IP' and it will show your public IP address without directing you to another website. Open the browser you prefer on your device and load this website: <a href="https://whatismyipaddress.com/">whatismyipaddress.com</a>. After a couple of seconds, it will show you your public IP address, and you won&rsquo;t have to do anything else to get them. Here&rsquo;s what it looks like in Windows:</p>
<p>However, none of these ways can work as we assume nobody is behind your computer so you should do it automatically. I wrote a concise Java code that can get your router's public IP address from the IP query server (<a href="https://ipinfo.io/">https://ipinfo.io/</a>) and save it in a text file named 'myIP.txt' along with the exact date and time of the query, but you don't need to compile it yourself. You can download the Jar file (executable) from <a href="https://github.com/Navid-Dian/MyIP_Finder.git">here</a> (GitHub).</p>
<p>Two main questions left to address; 1) Your computer should be on and obviosuly connected to the internet. 2) How to get the IP address from the home PC (host)</p>
<h4>3. Getting your home PC's public IP address remotely</h4>
<p>I will provide a solution for how to turn on your PC remotely, but let's assume your computer is powered on already. So, how to get your public IP address when you are away? To solve this I had a few considerations (constraints) such as I wanted to be simple, effective and available at no cost with no login requirement. The solution should also have no software installation requirement. Here's my approach.</p>
<p>As we now have an executable program (the Java app) that can save your router's public IP address on a text file, I've come up with the idea to use Windows Task Schuduler to run the Java app atutomaically by creating rules using IFTTT concept (If This Then That.). Windows Task Schuduler allows to set a trigger to run any program anytime with some conditions. Follow the intructions <a href="https://www.windowscentral.com/how-create-automated-task-using-task-scheduler-windows-10">here</a> to create an automated task using Task Scheduler.</p>
<p>After creating a automated task, the only problem left to solve is getting the text file including the IP address remotely to all necessary requirement to use the Remote Desktop. To get the file remotely, the simplest and easier way to create a free OneDrive account (it can be any cloud storage), put the Jar file in the OneDrive Folder and then create another task in Windows Task Schuduler for OneDrive Updater program, reposible for syncing the OneDrive folder. This task should be triggered when my PC is powered on, connected to the home WiFi and obviously after the text file generated. So, when you turn on your PC, before login screen, Task Scheduler first run the Jar file leading to generate the text file, second run the OneDrive Updater if your PC is connected to the WiFi. After a few seconds (depends on your home computer, Internet connnection speed) you can see the file in the Onedrive app on your phone.</p>
<p>/*To allow to your PC to run both programs before login, the 'Run whether user is logged in or not' should be checked when creating a task.*</p>
<h4>4. Turning on your PC remotely</h4>
<p>Now let find a solution for the final problem; Turing on your home computer on demand. To use your home computer with any remote desktop client applications, your computer should be on all times. This is not feasible mostly because of electricity bill. The best way to solve this problem and turn on your computer on demand is to use smart switches and plugs. These gadgets are highly efficient and their power consumption is very little compared to your PC.</p>
<h4>5. Turning on your PC with Virtual Voice Assistants (Alexa, Siri, etc.) remotely</h4>
<p>You need two additional devices apart from a smart speaker (e.g., HomePod [Siri], Echo Dot [Alexa], etc.)</p>
<p>Depending on your budget, there are plenty of smart plugs and button pushers you can buy. Some of the smart plugs include energy monitoring which is a plus. However, if you get the Switchbot Smart Switch Button Pusher, you will also need a Switchbot smart hub to control it from outside of your home network.</p>
<p>Here are my top recommendations for the best budget-friendly smart plugs in 2022:</p>
<ol>
<li>16A <a href="https://amzn.eu/d/hfh9Wz9">Smart Plug with Energy Monitoring</a>, WiFi Outlet Smart Sockets Alexa Accessories with Timing, Remote Control, Alexa, Google Home, IFTTT, TUYA Smart Plug Smart Life, No Hub Required (&pound;12)</li>
<li><a href="https://amzn.eu/d/apSD2ho">Eve Energy Smart Plug</a> (Apple Users) (&pound;29.99)</li>
</ol>
<p>Here are my top recommendations for the best budget-friendly Smart switch button pushers in 2022:</p>
<ul>
<li><a href="https://amzn.eu/d/iScsU4g">SwitchBot Smart Switch Button Pusher</a> (Amazon: &pound;29.99)</li>
<li><a href="https://amzn.eu/d/49QMAHk">SwitchBot Hub Mini Smart Remote Control</a> (Amazon: &pound;35)</li>
</ul>
<ul>
<li><a href="https://www.aliexpress.com/item/1005003135386915.html?channel=twinner">Fingerbot Switch Button Pusher</a> Smart Life App (AliExpress: &pound;18.52)</li>
</ul>
<p>If you have an iPhone and want to use Siri to turn on your computer and your smart plug or button pusher doesn't support Siri shortcuts (although almost all of them do support Alexa), you simply ask Siri to open Alexa and then ask Alexa to do the job. You can create a routine in the Alexa app o do particular things in order. Creating a routine for Alexa is easy and flexible. For example, the way I use it for turning on my PC is simply to ask first to turn on my PC plug, wait for 10 s (could be more or less) and then turn on my PC.</p>
