<select name="${name}" class="form-control">
    <#list options as option>
        <option value="${option.value}">${option.name}</option>
    </#list>
</select>
