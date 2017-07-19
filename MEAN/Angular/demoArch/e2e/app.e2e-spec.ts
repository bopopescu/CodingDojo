import { DemoArchPage } from './app.po';

describe('demo-arch App', () => {
  let page: DemoArchPage;

  beforeEach(() => {
    page = new DemoArchPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
