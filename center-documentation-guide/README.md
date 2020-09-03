# Postman Resource Center API Documentation Guide [Early Draft]

This project provides guidelines for documenting Postman collections for submission and inclusion in a Postman API Resource Center. 

## TODO / ISSUES

- This is an initial draft
- For the initial round, we probaly can't to support all propose elements. Some also likely need tweaking, testing, community/expert feedback. So the September edition is a proof of concpet / MVP. We should flag in the specifications below what is working draft vs release candidate vs supported recommendation. 
- We may also want to emphasize this is subject to change
- In the longer term, some could be added features to Postman app, or ultimate;y this could trickle into the OpenAPI specifications?


## Overview

Hosted and maintained by Postman, API Resource Centers are topic centric collection of APIs providing developers with a searchable list of known services providing access to data supporting analysis, policy making, inform the public, and other analytical purposes. Am example is the [COVID-19 Center](https://covid-19-apis.postman.com). For more information, visit the [Postman Toolbox Project](https://github.com/postman-toolboxes/covid-19).

While APIs are by nature useful, not all are equal in terms of technnical robustness, content quality, and developer support. The Postman team uses various mechanisms to rate and rank APIs in a resource center. Comprehensive documentation is essential requirement to support this exercise. 

The [Open API Specifications](https://www.openapis.org/), [Swagger](https://swagger.io/), and the [Postman](https://www.postman.com/) software offer industry standard solutions to do so. API documentation is however typically written for end-users and developers. While extremely useful, such content is not particulalry easy to understand by softwawre tools (a.k.a. not machine friendly). 

In order to facilite API indexing and quality assessment by software, we therefore introduce various mechanisms to embed tags and structured information in the documentation, describing data content and technical characteristics of an API, that can then be parsed to help rating and facilite discovery in the resource center. The parsing utilities are avaiable in our open source Git repository at <@todo: update when published>.

While this is not a hard requirement for API inclusion in a Postman Resource Center, the more information is available the better your assessment scores can be. Top ranked APIs will reflect the level of commitment by their maintainers to document their services.

### Metadata Embedding
Open standards and Postman at this time do not support extension mechanisms to capture API level structured metadata. We therefore need creative ways to embed the infornation we need in these existing environment. 

We considered various approaches, and settled for the use of HTML comments in markdown, with a tag to identify as content intended for the Postman resource center. This has the advantage of remaining hidden in rendered/generated documentation, and gives us the flexibility to insert simple text content, or complex JSON structure.

```
<-- postman:<optional_topic>
*** content goes here ***
-->
```

In addition, twitter like ```#hashtags``` to capture subject, keywords, or concepts. Selected markdown headings are also recognized for specific topics.

## Postman Resource Center Metadata Elements

The overall puspose is to populate the structure below capturing information on:

- custodian: the organization/individual/project behind the API, along with technical support options
- coverage: what are the topics/subjects, geographical regions, and time period covered by the data/information exposed by the API
- provenance: where is the information undelrying the API sourced from, and what are the tools and techniques used to curate or prepare the data.
- resources: Pointer to API documentations, examples, demos, videos, tutorials, web sites, videos, and other materials useful to developers or users
- profile: technical information around the infrastructure, performance, accessibility, and other technical aspects of the API

Note that different levels of details can be provided for each of the different elements and their properties:

- text: a sentence or paragraph describing
- structured object: a JSON object 
- standard based metadata: a JSON or JSON-LD object based on a global or industry standard

Higher level of details naturally requitre more efforts to put together, but will also positively impact the rating of your API in the resource center.

Some elements are repeatable, in which case that be provided in an JSON array.

### Syntax

The information can be provided in JSON format in a single HTML comment block starting with a ```postman``` keyword , like:

```postman
{
"custodian": ...
"coverage": ...
"provenance": ...
"profile": ...
"resources":...
}
```

or broken down into multiple blocks staring wiht a ```postman.<subject>``` keyword:

```postman:custodian
{
...custodian information...
}
```

with nested level allowed

```postman:custodian:contact
{
...custodian contact information...
}
```

### API Parsing Tool
Before you submit yourAPI to the fresource center, you can use our open source parsing tool to validate the content. This is available as a Python script in our [postman-utils](https://github.com/mtna/postman-utils) repository, or as a API at <t.b.d.>. The same tool is being used by Postman team to evaluate and score your API, as well as produce the JSON driving the resource center web site.


## Custodian
General information about the entity behind the API. This includes:

- Name, description, homepage
- Contact information
- type: the nature of the entity. Must be one of the following value: organization, person, group, project.

The ```name```, ```description```, ```homepage``` properties are self-explanatory.

The ```contact``` element provides infornation on the API custodian and how it can be contacted. It is further broken down into ```name```,```email```, ```homepage,```. More than one contact can be specified (in an array). In such case, the ```type ``` property should be used to should be used to. Expected type includes primary, support, admin, technical.

The custodian ```type``` property should be used to indicate the nature of the contact. Expected values are organization (default), person, group, project.

### Example

#### Descriptive Form

``` 
<!-- postman:custodian
{
This API is developed and maintained by Example Inc., an industry leader in API design and implementation. 
For general information, contact John Doe at info@example.org, or visit http://www.example.org. 
Our helpdesk is available at http://www.example.org/helpdesk. 
You can also reach technical support via email at support@example.org.
}
-->
```

#### Structured Form
``` 
<!-- postman:custodian
        "name": "Example Inc.",
        "description": "Example Inc is an industry leader in API design and implementation",
        "homepage": "http://www.example.org",
        "type": "organization",
        "contact": [
            {
                "name": "API team",
                "email": "info@example.org",
                "homepage": "",
                "type": "primary"
            },
            {
                "name": "Technical Support",
                "homepage": "http://www.example.org/helpdesk",
                "email": "support@example.org",
                "class": "group"
            }
-->
```

#### Standard FoaF Form [proposal]:
Future version of the tool may support information based on the following industry standard specifications.

A JSON-LD serialization of a W3C [Friend of a Friend](http://xmlns.com/foaf/spec/), using relevant elements such as Organization, Person, Project.

A JSON-LD serialization of a [schema.org](https://schema.org/docs/gs.html) [Organization](https://schema.org/Organization). or [Person](https://schema.org/Person).

## Coverage
The coverage element is used to document what the information being made accssible through the API is about. It is broken down into three sub-elemens:

- Topical coverage: a collection of generic or doamin specific subject, concepts, keywwords, topics 
- Geospatial coverage: which resions of the world 
- Time coverage

### Topical coverage

- Use an underscore for multiword concepts. Example: ```#covid-19:foo_bar```
- Use an hyphen to capture narrower concepts. Example: ```#covid-19:cases-confirmed```

#### Generic (in progress)


#### covid-19 (in progress)
```case, case-confirmed, case-active, test, testing, symptom, death, vaccine```

#### US Election 2020 (todo)
```poll, trend, ```


### Geospatial coverage

geo-location
- descriptive
- ISO 3166-2
- ISO 3166-2-??
- UN M49 (https://unstats.un.org/unsd/methodology/m49/)
- Places?

geo-levels:
Preferred: 
- generic: world | region | county | subnational
- <iso-country-code>-<common-level-name>
- <iso-country-code>-1|2|3
us-state, us-county, 


### Time coverage

- descriptive
- ISO 8601 time periods

## Provenance

#### Structured Form
``` 
<!-- postman:provenance
{
"source":""Example Inc.",
"homepage";""http://www.example.org",
"type":"organization",
"contact":[
{
	"name":"API team"
	"email":"info@example.org",
	"homepage:,
	"type":"primary"
}
,
{
	"name":"Technical Support"
	"homepage:"http://www.example.org/helpdesk",
	"email":"support@example.org",
	"class":"group",
}
-->
```

- sources
- curation


## Profile
@TODO

From a technical perspective, what do we need to know about the API? 

- How robust/reliable is it?
- Backed by: individual, private company, non-profit, public agency, academic
- Hosted on: premises, cloud (which one)
- Concurrent users/calls
- Expected availability: 7/7, 5/7, hours
- Responsiveness: sub-second, 1-2sec, varies
- Development Status: alpha/beta/MVP/production
- Available support
- Throttling
- CASC https://www.api.expert/industry/corpinfra/


## Resources

- Simple links
- Dublin core Resource
- schema.org [CreativeWork](https://schema.org/CreativeWork)


What mechanisms are in place to facilitate developer onboarding?
- Swagger
- Postman Docs
- List of sample applications using the API / Demos
- See the data before you start using the API
- Ability to browse/explore the data
- Blend that in the visualizer
- Add features to the visualizer to allow this 
- Link YouTube videos
- API tutorials

## Full Example
```
{

}
```

