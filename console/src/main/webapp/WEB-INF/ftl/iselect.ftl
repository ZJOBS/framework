<select name="${name}" class="form-control">
    <#list options as option>
        <#if defaultValue?exists>
            <#if option.value == defaultValue >
                <option value="${option.value}" selected>${option.name}</option>
            <#else>
                <option value="${option.value}">${option.name}</option>
            </#if>
        <#else>
            <option value="${option.value}">${option.name}</option>
        </#if>
    </#list>
</select>
