/* click mobile menu*/
function clickMobileBtn(mobileBtn, mobileMenu) {
    var _mobileBtn = document.querySelector(mobileBtn);
    var _mobileMenu = document.querySelector(mobileMenu);

    $(_mobileBtn).click(function () {
        $(_mobileMenu).slideToggle("slow");
    });
}

/* click searchbar */
function clickSearchbar(searchbar, hideItems, offset) {
    var _searchbar = document.querySelector(searchbar);
    var _hideItems = document.querySelector(hideItems);
    var _offset = document.querySelector(offset);

    $(_searchbar).click(function () {
        $(_hideItems).hide("slow", function () {
            var offset = $(_offset).offset();
            $("html body").animate({scrollTop: offset.top}, 2000);
        });
    });
}

/* chk validation of searching */
function chkSearching(searchBtn, searchBar, valCmt) {
    var _searchBtn = document.querySelector(searchBtn);
    var _searchBar = document.querySelector(searchBar);
    var _valCmt = document.getElementById(valCmt);

    $(_searchBtn).click(function () {

        if ($(_searchBar).val().length === 0) {
            _valCmt.innerHTML = "검색창에 주차장을 입력해주세요";
            return false;
        } else if ($('#tags').val().length < 3) {
            _valCmt.innerHTML = "세 글자 이상 입력해주세요";
            return false;
        } else {
            return true;
        }
    });
}

/* bmk delte action */
function deleteBmk(bmkName, cnt, first, last) {
  var _bmkName = bmkName;
  var _cnt = document.getElementById(cnt);
  var _first = first;
  var _last = last;

  console.log(_first);
  console.log(_last);

  var _cnt_near_num = parseInt(cnt) - 1;
  var _cnt_near = document.getElementById(_cnt_near_num);
  console.log(_cnt_near_num);
  console.log(_cnt_near);

  var r = confirm("이 주차장을 즐겨찾기에서 삭제하시겠습니까?");

  if (r == true) {
    var _email = '${ email }';

    $.ajax({
      url: "/DeleteBmk.aj",
      type: 'GET',
      data: {email: _email, bmkName: _bmkName},
      success: function (data) {
        if (data === 'success') {
          alert('삭제 성공');
          _cnt.style.display = 'none';

          if (_last === false) {
            /*if(_first) { return };*/
            alert('dd')
            _cnt_near.style.border = 'none';
          }

        } else if (data === 'fail') {

        }
      }
    })
  } else {

  }
}

/* go to detail page */
function goContentPage(name) {
  window.location.href = '/BoardSearchAction?PARKING_NAME' + name;
}

