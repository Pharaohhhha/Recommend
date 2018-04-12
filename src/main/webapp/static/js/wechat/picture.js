function imgPreview(fileDom){
    var span_warning = $("#span_warning");
    var input_picture = $("#input_picture");
    var div_picture = $("#div_picture");
    input_picture.attr("disabled",true);
    div_picture.css("background","#ccc");
    Bmob.initialize("f9a949289cfbb5cbb58a4f7fa4223978", "487653c01b7f94de3dccdea246259678");
    //判断是否支持FileReader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    }

    //获取文件
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否是图片
    if (!imageType.test(file.type)) {
        swal("","请上传图片","error");
        input_picture.attr("disabled",false);
        div_picture.css("background","#FA1616");
        return;
    }
    //读取完成
    reader.onload = function(e) {
        //获取图片dom
        var img = document.getElementById("user_pic");
        //图片路径设置为读取的图片
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
    var savefile = new Bmob.File(file.name, file);
    savefile.save().then(function  (obj) {
        var pictureUrl = obj.url();
        var openid = $("#openid").val();
        span_warning.text("正在识别,请稍等...");
        $.ajax({
            url:"picture?pictureUrl=" + pictureUrl+ "&openid=" + openid,
            async: false,
            type:"get",
            dataType:"json",
            success:function (data) {
                if(data == "1"){
                    span_warning.text("");
                    swal("","上传成功","success");
                }else{
                    span_warning.text("请上传正脸图片");
                    swal("","您上传的照片不符合要求","error");
                }
                input_picture.attr("disabled",false);
                div_picture.css("background","#FA1616");
            }
        });
    }, function  (error) {
        // body...
        console.log(JSON.stringify(error));
    });

}
