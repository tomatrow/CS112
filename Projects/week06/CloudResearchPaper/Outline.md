# Blendie in the Cloud Outline 
## Intro
* My first experience with the cloud was less unsatisfying. I had just received my first iPhone and was trying to simplify my life with technology. My first goal was never be bogged down by paper again. To accomplish this, I signed up for SimpleNote, a plain-text file syncing service. They provided a web interface and iOS(iPhoneOS at that time) integration, which was all I needed. Unfortunately, their syncing methods were far from perfect. Notes would get lost, conflicts arose, and entire paragraphs had the tendency to leave for some unknown plane of existence. I've changed my syncing services over the years, setting on Dropbox as the end-all be-all for my entire digital life. But, should I trust all my data in _their_ cloud? How can I even judge Simplenote if I can't implement synchronization myself? This essay will touch briefly on the Cloud, typical responses and my plans for the cloud in my own Apps.

### Cloud 
Like the rest of computing, _The Cloud_ is an abstraction over the Internet. Instead of envisioning a mass server farm contained by a ice-cold warehouse located in Utah, people are encouraged to think of the cloud the magical method for easily accessible data. This simple data access comes at he cost of complete privacy. Once information is transmitted over the Internet, there is a possibility of interception by an unknown entity, even if the transmission method is personally implemented. 

#### XKCD on the Cloud
According to XKCD, there are six general reactions to the possibility of privacy invasion with the cloud. The first is the Philosopher's viewpoint. He wants to disregard the concept of privacy in the digital realm. Privacy is just another real-world concept for something that does not exist with technology. The second is the Cryptography-Nut-job. He takes a polar opposite stance to the Philosopher. Instead of ignoring privacy all-together, he responds with an over-ambitious attempt to secure _all_ his data. Being completely secure is too burdensome task to manage. The next reaction is that of the Conspiracist. This one likes to take take each mass password leak, or newest Government spying scandal, and use it as evidence for a some massive privacy scheme. The forth way to react to privacy leaks is by being a Nihilist. The Nihilist looks at their personal data and sees it unworthy of protection. The last reaction to is by the Exhibitionist. He _loves_ for people to see his _personal_ data. 


### Blendie 
For the past four weeks I've been working on an iOS app called Blendie. I was chatting with a group of friends when one of them wanted to pitched an idea for a photo blending App. He wanted a minimal app with the ability to blend using the standard photo-shop filters. I agreed to provide the implementation and he would provide the design. As of today, Blendie is mostly functional. It's missing the ability to change the blending intensity. Eventually, I will want Blendie to communicate between all the devices tied to each user. I have four options available. 

## Four Options 
Drew McCormack outlined four approaches to syncing in his article _Data Synchronization_, part of the latest issue of "objc.io". He classifies four methods of networked communication as Synchronous or Asynchronous and Client-Server or Peer-to-Peer. Synchronous communication would be silly because communication with other device's is not part of it's main purpose. Having each phone talk to a server is not worth the upkeep. I don't want to pay for a host and I don't have a extra connected machine at home to use as a server. That leaves an Asynchronous-Peer-to-Peer as my best option. 

## Possible Implementations 
### Roll My Own 
I could roll my own implementation based off of Milen Dzhumerov's _Clear in the iCloud_ post. He outlines his techniques for keeping the ToDo-list manager, Clear, in sync across multiple devices. In his implementation, he keeps a high-level list of every change made in each object graph, then replays it from a certain baseline every time two object graphs merge. 

### Core Data with iCloud 
I could also use Apple's own Object Graph manager. Matthew Bischoff and Brian Capps claim iCloud has been made less unwieldy since its introduction in iOS5, and a built-in Framework is sure to have lots of answers on Stack Overflow and good documentation from Apple or web sources. 

### Ensembels 
A third option is to use a system like Ensembels. With a framework similar to Ensembels, I can have _my own_ system for syncing object graphs, yet not have to worry about a server. I can just use iCloud or Dropbox or even Amazon S3 for storing my files, and handle syncing on each device with the complexity I specify. It's like having my cake and eating it too. 

## Conclusion 
The cloud is a wonderfully complex implementation encapsulated into one simple idea. "All my data is safely stored in one place and is easily accessible". We should remember the user is our patron, king, judge and jury. Their experience with our Apps is critical for us, so we should go the extra mile for them. If that means pulling my hair out over conflict resolution, I'm happy for it.  

