window.onload = init;

function init() {
    var bdBtn = document.getElementById("baidu-btn");
    if (bdBtn != null) {
        bdBtn.onclick = baidu;
    }
}

function baidu() {
    var key = document.getElementById("keyword");

    if (key != null && key.value.trim().length > 0) {
        var bdimgUrl = "//image.baidu.com/search/index?tn=baiduimage&word=";
        window.location = bdimgUrl + key.value;
    }
}

function searchMusic() {
	var lo = document.getElementsByClassName("form")[0];
	lo.action = "search?code=2";
	lo.submit();
}