/**
 * created by hayk
 */

var applyScheme = function(e) {
	$('#schemeId').val($(this).data('scheme'));
	$('#scheme-selector').submit();
}

var init = function() {
	$('.scheme').on('click', applyScheme);
}

$(document).ready(init);