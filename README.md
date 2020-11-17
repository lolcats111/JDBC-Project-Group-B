# JDBC-Project-Group-B
## GIT How-To Guide
### Cloning a copy of the repo

1. Install Git on to your device: [Link](https://github.com/git-guides/install-git)
2. Clone the repo on to your device with the following command. Authorize yourself if prompted.
```
git clone https://github.com/lolcats111/JDBC-Project-Group-B.git
```


### Modify - Add - Commit - Push Loop

* Make a change to the project, e.g. add some code.
* To make that change merge with the repository, first add it:
```
git add .
```
This will add all new changes to a commit
* Now make a commit which represents a "unit of change", and give it a message:
```
git commit -m "I added this thingy."
```
* Finally push it to the branch you're working on, the `main` branch in this case, so it merges with the repository.
```
git push -u origin main
```
* Side note: To check whether there's any change that needs to be added, and commits that haven't been pushed, you can get the status as follows:
```
git status
```

### Pull
 * Get the changes in the hosted repo which aren't in your local repo:
 ```
git pull
 ```

**Rinse and Repeat.**

