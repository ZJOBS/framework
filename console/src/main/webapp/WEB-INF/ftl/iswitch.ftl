<script type="text/javascript">
    $('[name="status"]').bootstrapSwitch({
        onText: "启动",
        offText: "停止",
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("1");
            } else {
                $(this).val("2");
            }
        }
    });
</script>
<input name="activating" class="ace ace-switch ace-switch-6" type="checkbox">


