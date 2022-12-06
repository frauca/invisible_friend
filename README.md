# Invisible friend

I made this simple program as we orginize one invisible friend with the family, and sometimes is hard to meet all together. So I made this to make it online

## Execute

### Add your personal information

I do recomended never write your passwords. To run this I would make and application-local.yaml and there I would wrtie your information

```
spring:
    mail:
    username: gmail user name
    password: ${GMAIL_PASSWORD:not_even_here}

friends:
    - name: Your name
      mail: your mail
content:
  subject: This is a test from ${giver().name()}
  body: |
    This texts follows yaml format. 
    \n will be appended at the end of the line.
    You can use giver and receiver information. 
    Each one has name and mail.
    For example ${receiver().name()} will be replaced by it's name.
    Or ${sender().mail()} will be replaced by it's name.
```

I do have double factor authentication in gmail, so I need to [follow google app passwords](https://support.google.com/accounts/answer/185833?hl=en).

### Run the program

```
export SPRING_PROFILES_ACTIVE=local; ./gradlew bootRun
``
