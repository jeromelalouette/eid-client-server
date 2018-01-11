[![Build Status](https://travis-ci.org/Fedict/eid-java-web-start.svg?branch=develop)](https://travis-ci.org/Fedict/eid-java-web-start)

# eID Java Web Start

eID Java Web Start is a software component to easily give access to the Belgian Electronic Identity Card on the desktop.
The codebase is a continuation of the eID Applet that was deprecated in 2016 when applets became no longer supported
by the main browsers.

For more information on Java Web Start, see: https://www.java.com/en/download/faq/java_webstart.xml.  

## Building

eID Java Web Start can be build using a standard Maven build. Simply run the following command:
```
mvn clean install
```

## Code signing

Only signed code can be ran outside of the Java sandbox.
When the project is build, this component will automatically be signed with a self-signed certificate.

To sign with your own private key and certificate add the `codesigning` profile to the `.m2/settings.xml` file:
```xml
<profiles>
	<profile>
		<id>codesigning</id>
		<properties>
			<keystore.path>ABSOLUTE PATH TO THE KEYSTORE FILE</keystore.path>
			<keystore.type>TYPE OF THE KEYSTORE</keystore.type>
			<keystore.alias>ALIAS OF THE KEY IN THE KEYSTORE</keystore.alias>
			<keystore.password>KEYSTORE_PASSWORD</keystore.password>
		</properties>
	</profile>
</profiles>
```

Make sure you encrypt your keystore password: see https://maven.apache.org/guides/mini/guide-encryption.html.

For example:
```xml
<profiles>
	<profile>
		<id>codesigning</id>
		<properties>
			<keystore.path>/Users/foo/security/mykey.p12</keystore.path>
			<keystore.type>PKCS12</keystore.type>
			<keystore.alias>1</keystore.alias>
			<keystore.password>{f4Av613W9IgHOvNqJWatAdwPXvKwnqqLOqSwWLpHbig=}</keystore.password>
		</properties>
	</profile>
</profiles>
```

Then you can build the project with:
```
mvn clean install -Pcodesigning
```