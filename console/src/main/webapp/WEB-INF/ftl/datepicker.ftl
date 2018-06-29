<script type="text/javascript">
    $(function () {
        $("#${id}").datetimepicker({
            language: 'zh-CN',
            weekStart: 1,
            todayHighlight: true,
            format: '${format}',
            autoclose: true,
            pickerPosition: "bottom-right",
        });
    });
</script>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right">${text}</label>
    <div class="col-xs-12 col-sm-5">
        <div id="${id}" class="input-append date date-picker">
            <input size="16" type="text" name="${name}">
            <span class="add-on"><i class="icon-remove"></i></span>
            <span class="add-on"><i class="icon-calendar"></i></span>
        </div>
    </div>
</div>
