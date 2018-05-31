<div class="checkbox">
    <#list options as option>
        <label>
            <input name="form-field-checkbox" type="checkbox" class="ace" value="${option.value}">
            <span class="lbl">${option.name}</span>
        </label>
    </#list>
</div>