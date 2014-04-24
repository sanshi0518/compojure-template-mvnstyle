# compojure-template-mvnstyle

A maven style leiningen template for projects using [Compojure](https://github.com/weavejester/compojure).

## Usage

Run the following command to create a new Compojure project:

	lein new compojure-mvnstyle <your project name>

## License

Copyright © 2014 wanglei

Distributed under the Eclipse Public License, the same as Clojure.

------------

# Creating Leiningen Templates?

The following steps show the creating of present `compojure-mvnstyle` template.

## Create a template project

	lein new template compojure-template-mvnstyle

## Stuff the project.clj with detail description

```clojure
(defproject compojure-mvnstyle/lein-template "0.1.0-SNAPSHOT"
  :description "A maven style leiningen template for projects using compojure"
  :url "https://www.github.com/sanshi0518/compojure-template-mvnstyle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true)
```

In order to change template name to a short one, you should:

- Adjust the project name configuration in the project.clj
- Rename compojure_template_mvnstyle.clj to compojure_mvnstyle.clj, do not forget its content
- Rename compojure_template_mvnstyle directory to compojure_mvnstyle

## Customize the application creating function

The actual application creating function resides under:

	src/leiningen/new/compojure_mvnstyle.clj
	
It looks as follows:

[compojure_mvnstyle.clj](https://github.com/sanshi0518/compojure-template-mvnstyle/blob/master/src/leiningen/new/compojure_mvnstyle.clj)

The `compojure-mvnstyle` function is where all the fun happens, and it's what gets called when we run lein new compojure-mvnstyle myapp to create an application using this template.

The function is mostly self explanatory. It uses the render function from leiningen.new.templates to take the template files and put them at the specified path. 

Our template files live under:

	src/leiningen/new/compojure_mvnstyle

And they don't need to have the same folder structure as the resulting project. We can specify the resulting path explicitly in our template.

> ***Note:***

> The template files folder and clojure file use ***underline*** as hyphen, but the function name and project name use ***minus*** instead.

## Install the template locally

Firstly, install the template using: 

	lein install

It will package the template project and install the jar to local maven repository.

Secondly, add it as a plugin to your profile under ~/.lein/profiles.clj using the following format:

	{:user
      {:plugins [[compojure-mvnstyle/lein-template "0.1.0-SNAPSHOT"]]}}

That's it, you can now use your new template and never have to write boilerplate for this kind of project again.

	lein new compojure-mvnstyle hello-world

## Publish the template to Clojars

If you wish to make your template available to others you can publish it to Clojars by running:

	lein deploy clojars
	
It will publish the jar to clojars, instead of installing it to the local maven repository.

Any template published on Clojars can be used directly without needing to add it to your plugins in the profiles.clj as shown above.

## Reference material

[Creating Leiningen Templates](http://yogthos.net/blog/34-Creating+Leiningen+Templates)

[compojure-template](https://github.com/weavejester/compojure-template)

[lein-webapp-template](https://github.com/eprunier/lein-webapp-template)