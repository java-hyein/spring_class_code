package edu.bit.board.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private Criteria cri; // page, perPageNum�� ������ �ִ� (���� 4����������)
							// �� ���� �������� ������ ������

	// [11][12][13].......[20] : ���� �������� 13�� �� startPage�� 11, endPage�� 20
	private int startPage; // �Խñ� ��ȣ�� ���� (��������)�������� ���� ��ȣ
	private int endPage; // �Խñ� ��ȣ�� ���� (��������)�������� ������ ��ȣ

	private boolean prev; // << ��ư ��� ���� ���� ��ư�� ���� �� �ִ� ���/���� ��� �з��� ����
	private boolean next; // >> ��ư ��� ����

	private int displayPageNum = 10; // ȭ�� �ϴܿ� �������� �������� ����
	private int tempEndPage; // ������ �������� ��Ƶα� ���� ����

	private int totalCount; // ��ü �Խñ� ��
	/////////////////////////////////////////////////////////////////////////////////////////////

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData(); // TotalCount�� set �ɶ� 10������ �����Ѵ�. ��ü �ʵ� ������ ���� : ��ü �Խñ� ���� setter�� ȣ��� �� ��ü
					// ���õǵ��� ��
	}

	private void calcData() { // ��ü ���� ������ ����ϴ� �޼���

		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		// ���������� ������ ���� ���������� ���� ����
		// ex) ���� ������(pageInfo.getPage()) = 3
		// �ϴ� ����¡ �ٿ� ������ ����¡�� ���� = displayPageNum = 10��
		// ���� : ceil(3 / 10.0) * 10 => 1 * 10 = 10����
		// 1. (3/10.0) = 0.3
		// 2. ceil(0.3) = 1 (�ø�)
		// 3. 1* 10 = 10
		// 1 2 3 4 5 6 7 8 9 10

		startPage = (endPage - displayPageNum) + 1;

		// �������� ������ ���� ���� �������� ���� ����
		// ex) ���������� pageInfo.getPage()) = 3
		// �������� endPage = 10
		// �ϴ� ����¡ �ٿ� ������ ����¡�� ���� = displayPageNum = 10
		// ���������� = (10 - 10) + 1 = 1

		// ���������� 3���κ��� endPage�� ��������(10)
		// �ش� �������� ������������ ���� ����

		// ex) ���������� pageInfo.getPage()) = 13
		// �������� endPage = 20
		// �ϴ� ����¡ �ٿ� ������ ����¡�� ���� = displayPageNum = 10
		// ���������� = (20 - 10) + 1 = 11

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		this.tempEndPage = tempEndPage;

		// ��ü �� �������� :
		// totalCount = select count(*) from tbl_count�� �����
		// pageInfo.getPerPageNum = �� ȭ�鿡 ����� ���� ����
		// ex) totalCount = 512
		// pageInfo.getPerPageNum = 10
		// tempEndPage = ceil(512 / 10.0) = 52
		// 51.2�ǰ���� �ø� => 51������ ������ �� ȭ��� 10���� �Խù��� ���
		// ������ 52���������� 0.2�� �ش��ϴ� 2���� �Խù��� ���

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
			//endPage�� 60 �̰� tempEndPage�� 52�̶�� �ϸ� endpage�� ���� tempPage�� �ٲ��ش�.
			//�ᱹ�� endpage�� 52�� �Ǵ°� 
		}
		
		prev = (startPage == 1) ? false : true;
		// ====> ���� 1~10�������� ����� ���� ������ '<<'��ư ����s
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("prev : " + prev);
		
		next = (endPage * cri.getPerPageNum()) >= totalCount ? false : true;
		// ====> �� 100������, ����ϴ� �������� 90~100�϶� ������ '>>'��ư ����
		System.out.println("next" + next);
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("page", page) // page = 3
				.queryParam("perPageNum", cri.getPerPageNum()) // page=3&perPageNum=10
				.build(); // ?page=3&perPageNum=10 <== get��Ŀ� ���� key,value
						  // �Խ��� �Ʒ� ��ȣ�� ��ũ�ε� 30�� ���� 40���� ������ �����´� 
		return uriComponentsBuilder.toUriString(); // ?page=3&perPageNum=10�� ���� ����
	}

}
