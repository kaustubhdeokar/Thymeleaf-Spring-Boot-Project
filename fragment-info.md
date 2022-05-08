### fragment - to avoid Duplication of CSS
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <div th:fragment="separator"> 
        <div class="border-dashed border-2 border-red-300 mx-4">
        </div>
    </div>
</body>
</html>


### way to insert.
<div>
  <div>There is some content here.</div>
  
  <div th:insert="~{fragments :: separator}"></div> 


  <div>There is some more content here.</div>
</div>


### result html.

<div>
  <div>There is some content here.</div>
  
  <div>
        <div class="border-dashed border-2 border-red-300 mx-4">
        </div>
  </div>

  <div>There is some more content here.</div>
</div>


<b>We can set the fragment and class on the same div to avoid nesting of div's</b>

Instead of insert, we can perform replace too. 

## Parameters

<a th:fragment="menu-item(title, link)" 
    th:text="${title}" 
    th:href="${link}"
    
> Use:
```
<a th:replace="fragments :: menu-item('users','/users')"></a>
<a th:replace="fragments :: menu-item('groups','/groups')"></a>
```



```
<a href="/users" class="flex items-center px-2 py-2 text-base leading-6 font-medium
text-gray-900">Users</a>
<a href="/groups" class="flex items-center px-2 py-2 text-base leading-6 font-medium
text-gray-900">Groups</a>
```


