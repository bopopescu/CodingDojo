import { ExpressdemoPage } from './app.po';

describe('expressdemo App', () => {
  let page: ExpressdemoPage;

  beforeEach(() => {
    page = new ExpressdemoPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
