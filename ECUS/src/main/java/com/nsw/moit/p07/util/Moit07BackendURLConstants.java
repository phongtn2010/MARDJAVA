package com.nsw.moit.p07.util;

public class Moit07BackendURLConstants {

	public static final String ROOT_URL = "moit.07.backend";

	public final class TbdHoSo7Constants {

		private TbdHoSo7Constants() {}

		public static final String CREATE = "/moit/07/hoSo/create";
		public static final String UPDATE = "/moit/07/hoSo/update";
		public static final String DELETE = "/moit/07/hoSo/delete";
		public static final String GET_ONE = "/moit/07/hoSo/get";
		public static final String FIND_BY_MA_HO_SO = "/moit/07/hoSo/findByMaHoSo";
		public static final String FIND_BY_ID_HO_SO = "/moit/07/hoSo/findByIdHoSo";
		public static final String SEARCH = "/moit/07/hoSo/search";
		public static final String COUNT = "/moit/07/hoSo/count";

	}

	public final class TbdDinhKem7Constants {

		private TbdDinhKem7Constants() {}

		public static final String CREATE = "/moit/07/tepTin/create";
		public static final String UPDATE = "/moit/07/tepTin/update";
		public static final String DELETE = "/moit/07/tepTin/delete";
		public static final String GET_ONE = "/moit/07/tepTin/get";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_TEP_TIN_ASC = "/moit/07/tepTin/findByIdHoSoAndHoatDong";
		public static final String GET_BY_TEP_DINH_KEMS = "/moit/07/tepTin/getByTepDinhKems";

	}

	public final class TbdHangHoa7Constants {

		private TbdHangHoa7Constants() {}

		public static final String CREATE = "/moit/07/hangHoa/create";
		public static final String UPDATE = "/moit/07/hangHoa/update";
		public static final String DELETE = "/moit/07/hangHoa/delete";
		public static final String GET_ONE = "/moit/07/hangHoa/get";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_HANG_HOA_ASC = "/moit/07/hangHoa/findByIdHoSoAndHoatDong";

	}

	public final class TbdCuaKhau7Constants {

		private TbdCuaKhau7Constants() {}

		public static final String CREATE = "/moit/07/cuaKhau/create";
		public static final String UPDATE = "/moit/07/cuaKhau/update";
		public static final String DELETE = "/moit/07/cuaKhau/delete";
		public static final String GET_ONE = "/moit/07/cuaKhau/get";
		public static final String FIND_BY_ID_HO_SO_AND_MA_CUA_KHAU = "/moit/07/cuaKhau/findByIdHoSoAndMaCuaKhau";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_CUA_KHAU_ASC = "/moit/07/cuaKhau/findByIdHoSoAndHoatDong";
		public static final String GET_ALL_CUA_KHAUS = "/moit/07/cuaKhau/getAllCuaKhaus";

	}

	public final class TbdGiayPhep7Constants {

		private TbdGiayPhep7Constants() {}

		public static final String CREATE = "/moit/07/giayPhep/create";
		public static final String UPDATE = "/moit/07/giayPhep/update";
		public static final String DELETE = "/moit/07/giayPhep/delete";
		public static final String GET_ONE = "/moit/07/giayPhep/get";
		public static final String FIND_BY_ID_HO_SO = "/moit/07/giayPhep/findByIdHoSo";
		public static final String FIND_BY_MA_SO_G_P = "/moit/07/giayPhep/findBySoGiayPhep";

	}

	public final class TbdYCRut7Constants {

		private TbdYCRut7Constants() {}

		public static final String CREATE = "/moit/07/yeuCauRut/create";
		public static final String UPDATE = "/moit/07/yeuCauRut/update";
		public static final String DELETE = "/moit/07/yeuCauRut/delete";
		public static final String GET_ONE = "/moit/07/yeuCauRut/get";
		public static final String FIND_BY_ID_HO_SO = "/moit/07/yeuCauRut/findByIdHoSo";

	}

	public final class TbdKQXL7Constants {

		private TbdKQXL7Constants() {}

		public static final String CREATE = "/moit/07/ketQuaXuLy/create";
		public static final String UPDATE = "/moit/07/ketQuaXuLy/update";
		public static final String DELETE = "/moit/07/ketQuaXuLy/delete";
		public static final String GET_ONE = "/moit/07/ketQuaXuLy/get";
		public static final String SEARCH_KET_QUA_XU_LYS = "/moit/07/ketQuaXuLy/searchKetQuaXuLys";
		public static final String COUNT_KET_QUA_XU_LYS = "/moit/07/ketQuaXuLy/countHoSos";

	}

	public final class TbdTTPT7Constants {

		private TbdTTPT7Constants() {}

		public static final String CREATE = "/moit/07/phuongTien/create";
		public static final String UPDATE = "/moit/07/phuongTien/update";
		public static final String DELETE = "/moit/07/phuongTien/delete";
		public static final String GET_ONE = "/moit/07/phuongTien/get";
		public static final String FIND_BY_ID_HO_SO_AND_LOAI_PHUONG_TIEN = "/moit/07/phuongTien/findByIdHoSoAndLoaiPhuongTien";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_PHUONG_TIEN_ASC = "/moit/07/phuongTien/findByIdHoSoAndHoatDong";

	}

	public final class TbsCuaKhau7Constants {

		private TbsCuaKhau7Constants() {}

		public static final String GET_ONE = "/moit/07/tbsCuaKhau/get";
		public static final String FIND_BY_ID_CUA_KHAU = "/moit/07/tbsCuaKhau/findByIdCuaKhau";
		public static final String FIND_BY_ID_CUA_KHAU_IS_NOT_NULLORDER_BY_TEN_CUA_KHAU_ASC = "/moit/07/tbsCuaKhau/findByIdCuaKhauIsNotNull";
		public static final String GET_ALL = "/moit/07/tbsCuaKhau/getAll";

	}

	public final class TbsPhuongTien7Constants {

		private TbsPhuongTien7Constants() {}

		public static final String GET_ONE = "/moit/07/tbsPhuongTien/get";
		public static final String FIND_BY_ID_PHUONG_TIEN = "/moit/07/tbsPhuongTien/findByIdPhuongTien";
		public static final String FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULLORDER_BY_TEN_PHUONG_TIEN_ASC = "/moit/07/tbsPhuongTien/findByIdPhuongTienIsNotNull";
		public static final String GET_ALL = "/moit/07/tbsPhuongTien/getAll";

	}

	public final class TbsTrangThai7Constants {

		private TbsTrangThai7Constants() {}

		public static final String GET_ONE = "/moit/07/tbsTrangThai/get";
		public static final String FIND_BY_ID_TRANG_THAI_IS_NOT_NULLORDER_BY_ID_TRANG_THAI = "/moit/07/tbsTrangThai/findByIdTrangThaiIsNotNull";
		public static final String FIND_BY_ID_TRANG_THAI = "/moit/07/tbsTrangThai/findByIdTrangThai";
		public static final String GET_ALL = "/moit/07/tbsTrangThai/getAll";

	}

	public final class TbsTienChat7Constants {

		private TbsTienChat7Constants() {}

		public static final String GET_ONE = "/moit/07/tienChat/get";
		public static final String FIND_BY_ID_TIEN_CHAT = "/moit/07/tienChat/findByIdTienChat";
		public static final String FIND_BY_ID_TIEN_CHAT_IS_NOT_NULLORDER_BY_TEN_TIEN_CHAT = "/moit/07/tienChat/findByIdTienChatIsNotNullOrderByTenTienChat";

	}

	public final class TbdLichSu7Constants {

		private TbdLichSu7Constants() {}

		public static final String CREATE = "/moit/07/lichSu/create";
		public static final String UPDATE = "/moit/07/lichSu/update";
		public static final String DELETE = "/moit/07/lichSu/delete";
		public static final String GET_ONE = "/moit/07/lichSu/get";
		public static final String SEARCH_KET_QUA_XU_LYS = "/moit/07/lichSu/search";
		public static final String COUNT_KET_QUA_XU_LYS = "/moit/07/lichSu/countHoSos";

	}
	
	public final class TbdGPHangHoa7Constants {

		private TbdGPHangHoa7Constants() {}

		public static final String CREATE = "/moit/07/gpHangHoa/create";
		public static final String UPDATE = "/moit/07/gpHangHoa/update";
		public static final String DELETE = "/moit/07/gpHangHoa/delete";
		public static final String GET_ONE = "/moit/07/gpHangHoa/get";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_HANG_HOA_ASC = "/moit/07/gpHangHoa/findByIdHoSoAndHoatDong";

	}

	public final class TbdGPCuaKhau7Constants {

		private TbdGPCuaKhau7Constants() {}

		public static final String CREATE = "/moit/07/gpCuaKhau/create";
		public static final String UPDATE = "/moit/07/gpCuaKhau/update";
		public static final String DELETE = "/moit/07/gpCuaKhau/delete";
		public static final String GET_ONE = "/moit/07/gpCuaKhau/get";
		public static final String FIND_BY_ID_HO_SO_AND_MA_CUA_KHAU = "/moit/07/gpCuaKhau/findByIdHoSoAndMaCuaKhau";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_CUA_KHAU_ASC = "/moit/07/gpCuaKhau/findByIdHoSoAndHoatDong";

	}

	public final class TbdGPTTPT7Constants {

		private TbdGPTTPT7Constants() {}

		public static final String CREATE = "/moit/07/gpPhuongTien/create";
		public static final String UPDATE = "/moit/07/gpPhuongTien/update";
		public static final String DELETE = "/moit/07/gpPhuongTien/delete";
		public static final String GET_ONE = "/moit/07/gpPhuongTien/get";
		public static final String FIND_BY_ID_HO_SO_AND_LOAI_PHUONG_TIEN = "/moit/07/gpPhuongTien/findByIdHoSoAndLoaiPhuongTien";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_PHUONG_TIEN_ASC = "/moit/07/gpPhuongTien/findByIdHoSoAndHoatDong";

	}


}