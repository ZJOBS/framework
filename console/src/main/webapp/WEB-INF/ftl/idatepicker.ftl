<script type="text/javascript">
    jQuery(function ($) {
        $(".date-picker").datetimepicker({
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
    <label class="col-sm-3 control-label no-padding-right">日期选择</label>
    <div class="col-xs-12 col-sm-5">
        <div class="input-append date date-picker">
            <input size="16" type="text" value="" readonly>
            <span class="add-on"><i class="icon-remove"></i></span>
            <span class="add-on"><i class="icon-calendar"></i></span>
        </div>
    </div>
</div>




