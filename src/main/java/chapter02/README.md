
Item 1. Consider static factory methods instead of constructors. (page 28)
* One advantage of static factory methods is that, unlike constructors, they have names.

Ex.
```Java
    User.createUnknownCommonUser();
```

Make more sense then:

```Java
    new User();
```

If we have many kinds of Users, createUnknownCommonUser, createMasterUser is easier to read.


* A second advantage of static factory methods is that, unlike constructors, they are not
required to create a new object each time they’re invoked.

The User have three static factory method and uses the following logic:

```Java
    if (alreadyCreated(userName))
     return historyOfCreatedUsers.get(userName);
```

In this case, we have cached users object map and just return them.


* A third advantage of static factory methods is that, unlike constructors, they can return
an object of any subtype of their return type


The method createUser return a SpecialUser in the creation of Masters users

```Java
    if (userType.equals(UserType.MASTER))
            return new SpecialUser(userType,userName);
```