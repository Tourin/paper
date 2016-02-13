PrimeFaces.locales['jp'] = {

	closeText : '閉じる',
	prevText : '前へ',
	nextText : '次へ',
	monthNames : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月',
			'11月', '12月' ],
	monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10',
			'11', '12' ],
	dayNames : [ '日曜日', '月曜日', '火曜日', '水曜日', '木曜日', '金曜日', '土曜日' ],
	dayNamesShort : [ '日曜', '月曜', '火曜', '水曜', '木曜', '金曜', '土曜' ],
	dayNamesMin : [ '日', '月', '火', '水', '木', '金', '土' ],
	weekHeader : '週',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : true,
	yearSuffix : '',
	timeOnlyTitle : '時間のみ',
	timeText : '時間',
	hourText : '時',
	minuteText : '分',
	secondText : '秒',
	currentText : '今日',
	ampm : false,
	month : '月',
	week : '週',
	day : '日',
	allDayText : '終日'
};

PrimeFaces.locales['zh_cn'] = {
		clearText : '清除',
		clearStatus : '清除已选日期',
		closeText : '关闭',
		closeStatus : '不改变当前选择',
		prevText : '<上月',
		prevStatus : '显示上月',
		prevBigText : '<<',
		prevBigStatus : '显示上一年',
		nextText : '下月>',
		nextStatus : '显示下月',
		nextBigText : '>>',
		nextBigStatus : '显示下一年',
		currentText : '今天',
		currentStatus : '显示本月',
		monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月',
				'十一月', '十二月' ],
		monthNamesShort : [ '一', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一',
				'十二' ],
		monthStatus : '选择月份',
		yearStatus : '选择年份',
		weekHeader : '周',
		weekStatus : '年内周次',
		dayNames : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
		dayNamesShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
		dayNamesMin : [ '日', '一', '二', '三', '四', '五', '六' ],
		dayStatus : '设置 DD 为一周起始',
		dateStatus : '选择 m月 d日, DD',
		firstDay : 1,
		initStatus : '请选择日期',
		isRTL : false,
		currentText : "现在",
		closeText : "完成",
		ampm : false,
		amNames : [ "上午", "A" ],
		pmNames : [ "下午", "P" ],
		timeSuffix : "",
		timeOnlyTitle : "选择时间",
		timeText : "时间",
		hourText : "时",
		minuteText : "分",
		secondText : "秒",
		millisecText : "毫秒",
		timezoneText : "时区",
		month : '月',
		week : '周',
		day : '日',
		allDayText : '全天'
	};
	PrimeFaces.locales['zh_CN'] = PrimeFaces.locales['zh_cn'];

(function(window) {
	if (window.S2I) {
		return;
	}

	var MIN_HEIGHT = 719;
	var doFocus = function(object) {
		/* don't move focus when have input errors */
		if ($('.ui-state-error.ui-inputfield').length > 0) {
			return;
		}
		$(object)[0].scrollIntoView(true);
		setTimeout(function() {
			$(object).focus();
		}, 250);
	};

	var syncWidthOfTable = function(table, isPopup) {
		if ($(table).find(".ui-datatable-scrollable-body table tr:first td").length > 1) {
			var total = 0;
			var viewWidth = isPopup ? $('.popup-list').width() : $('#container').width();
			var header=$(table).find('.ui-datatable-scrollable-header');
			var body=$(table).find('.ui-datatable-scrollable-body');
			header.width(5000);
			body.width(5000);
			header.find('.ui-datatable-scrollable-header-box table tr th')
					.each(function(i) {
								var target = $(body.find("table tr:first td")[i]);
								var width = Math.max(target.width(), $(this).width()) + 1;
								
								$(this).width(width);
								$(target).width(width);
								total += $(this).outerWidth();
							});
			total += 20; /*plus scrollbar*/
			header.width(Math.max(viewWidth, total));
			body.width(total);
			if(isPopup == false && total <= viewWidth){
				body.css(
						'height', Math.max(MIN_HEIGHT, $('body').innerHeight()) -
						body.offset().top - 70);
			}
		}
	};
	
	S2I = {
		enterBlur : function(object) {
			if (event.keyCode == $.ui.keyCode.ENTER) {
				$(object).blur();
				return false;
			}
		},

		focus : function(expr) {
			doFocus(expr);
		},
		selectOnFocus : function(el) {
			setTimeout(function(){
				el.select();
			});
		},
		enterBlurOrFocus : function(object, expr) {
			if (event.keyCode == $.ui.keyCode.ENTER) {
				var o = $(object).closest("tr").find(expr).not(object);
				if (o.length == 0) {
					$(object).blur();
				} else {
					o.focus();
				}
				return false;
			}
		},

		focusAfterAjax : function(object, expr) {
			var source = object.source;
			doFocus($(PrimeFaces.escapeClientId(source)).closest("tr").find(
					expr));
		},

		focusNextRowAfterAjax : function(object, expr) {
			var source = object.source;
			doFocus($(PrimeFaces.escapeClientId(source)).closest("tr").next()
					.find(expr));
		},
		syncWidth : function() {
			$('.ui-datatable-scrollable-header-box').css('margin-right', 0);
			$('.ui-datatable-scrollable-body').css('margin-right', 0);
			$('.ui-datatable-scrollable').not('.popup-list .ui-datatable-scrollable').each(function() {
				syncWidthOfTable(this, false);
			});
			$('.popup-list .ui-datatable-scrollable').each(function() {
				syncWidthOfTable(this, true);
			});
		},
		syncHeight : function() {
			var viewHeight = Math.max(MIN_HEIGHT, $('body').innerHeight());
			$('div.ui-datatable-scrollable-body').not('.popup-list .ui-datatable-scrollable-body').each(
					function() {
						$(this).css(
								'height', viewHeight -
								$(this).offset().top - 90);
					});
		},
		ajaxStart : function() {
			/*
			bui.show();
			*/

		},
		ajaxEnd : function() {
			/*
			bui.hide();
			S2I.syncHeight();
			S2I.syncWidth();
			*/
		},
		setErrorClientId : function(clientId) {
			S2I.errorClientId = S2I.errorClientId || clientId;
		},
		focusError : function() {
			if(S2I.errorClientId) {
				$(PrimeFaces.escapeClientId(S2I.errorClientId)).focus();
				S2I.errorClientId = undefined;
			} else {
				$('input.ui-state-error:first').focus();
			}
		}
	};

	window.S2I = S2I;
})(window);
/*show message dialog for non-ajax request
$(function() {
	setTimeout(function() {
		if ($("#warningDialog .ui-messages ul").length > 0) {
			warningDialogWidget.show();
		}
		if ($("#infoDialog .ui-messages ul").length > 0) {
			infoDialogWidget.show();
		}
	}, 250);
});
*/

